package dlrtn.sns.config.datasource;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import jakarta.annotation.PreDestroy;
import java.util.Properties;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * 내부 네트워크에서만 접속 가능한 원격 데이터베이스에 터널링하기 위한 클래스
 * SSH 연결을 위해 JSch를 포크한 mweide를 사용(JSch 라이브러리의 제약사항이 많아 선택)
 */
@Slf4j
@Profile("local")
@Component
@ConfigurationProperties(prefix = "ssh")
@Setter
public class SshTunnelingInitializer {

    private String sshHost;
    private int sshPort;
    private String sshUsername;
    private String privateKey;

    private int remoteDatabasePort;
    private String remoteDatabaseHost;

    private Session session;

    /**
     * 애플리케이션 컨텍스트가 종료될 때 SSH 세션을 닫습니다.
     */
    @PreDestroy
    public void close() {
        if (session != null && session.isConnected()) {
            session.disconnect();
            log.info("SSH 세션이 종료되었습니다");
        }
        log.info("SSH 세션이 연결되지 않았습니다");
    }

    /**
     * 포트 포워딩을 설정하여 SSH 터널을 생성합니다.
     *
     * @return 원격 데이터베이스 포트로 포워딩된 로컬 포트.
     * @throws JSchException SSH 세션 설정 또는 터널링 시 오류가 발생한 경우.
     */
    public Integer buildTunnel() throws JSchException {
        try {
            return session.setPortForwardingL(0, remoteDatabaseHost,
                    remoteDatabasePort);
        } catch (JSchException e) {
            log.error("SSH 세션 설정 실패", e);
            this.close();
            throw e;
        }
    }

    public void buildSession() throws JSchException {
        try {
            JSch jSch = new JSch();
            jSch.addIdentity(privateKey);
            session = jSch.getSession(sshUsername, sshHost, sshPort);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            session.connect();

            log.info("SSH 세션이 연결되었습니다");
        } catch (JSchException e) {
            log.error("SSH 세션 설정 실패", e);
            this.close();
            throw e;
        }
    }
}
