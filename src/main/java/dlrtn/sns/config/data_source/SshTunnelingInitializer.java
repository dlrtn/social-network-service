package dlrtn.sns.config.data_source;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import jakarta.annotation.PreDestroy;
import java.util.Properties;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Profile("local")
@Component
@ConfigurationProperties(prefix = "ssh")
@Setter
public class SshTunnelingInitializer {

    private String sshHost;

    private int sshPort;

    private String sshUserName;

    private String privateKey;

    private String passPhrase;

    private int remotePort;

    private Session session;

    @PreDestroy
    public void close() {
        if (session.isConnected()) {
            session.disconnect();
        }
        log.info("session is closed");
    }

    public Integer buildSshTunnel() {
        Integer forwardedPort = null;

        try {
            JSch jSch = new JSch();
            jSch.addIdentity(privateKey, passPhrase);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");

            session = jSch.getSession(sshUserName, sshHost, sshPort);
            session.setConfig(config);
            session.connect();  // ssh 연결

            forwardedPort = session.setPortForwardingL(0, "localhost", remotePort);
        } catch (Exception e) {
            log.error("fail to make ssh session", e);
        } finally {
            this.close();
        }
        return forwardedPort;
    }
}
