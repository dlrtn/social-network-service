package dlrtn.sns.common.swagger;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {
        return new OpenAPI().components(new Components()).info(getInfo());
    }

    @Bean
    public GroupedOpenApi userOpenApi() {
        return GroupedOpenApi.builder().group("users").pathsToMatch("/users/**").build();
    }

    private Info getInfo() {
        return new Info().title("Social Network Service Example")
                .description("학습한 소프트웨어 개념 연습을 위한 예제입니다.").version("0.0.1");
    }

}
