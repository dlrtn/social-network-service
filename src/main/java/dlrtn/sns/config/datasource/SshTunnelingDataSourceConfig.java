package dlrtn.sns.config.datasource;

import com.jcraft.jsch.JSchException;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * 로컬 환경에서 데이터베이스 이용을 위한 SSH 터널링 데이터 소스 설정 클래스.
 */
@Slf4j
@Profile("local")
@Configuration
@RequiredArgsConstructor
public class SshTunnelingDataSourceConfig {

    private final SshTunnelingInitializer initializer;

    /**
     * SSH 터널링을 통해 데이터 소스를 생성하고 구성합니다.
     *
     * @param properties 애플리케이션에 설정된 데이터 소스 속성.
     * @return 구성된 데이터 소스.
     * @throws JSchException SSH 세션 연결 및 터널링 중 오류가 발생한 경우.
     */
    @Bean()
    public DataSource dataSource(DataSourceProperties properties) throws JSchException {
        initializer.buildSession();
        Integer forwardedPort = initializer.buildTunnel();

        String url = properties.getUrl()
                .replace("[forwardedPort]", forwardedPort.toString());
        log.info("포워딩된 포트가 포함된 데이터베이스 URL: {}", url);

        return DataSourceBuilder.create()
                .url(url)
                .username(properties.getUsername())
                .password(properties.getPassword())
                .driverClassName(properties.getDriverClassName())
                .build();
    }
}
