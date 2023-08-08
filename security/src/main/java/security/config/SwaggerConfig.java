package security.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi applicationApi() {
        String[] paths = {"/user/**"};
        return GroupedOpenApi.builder().group("application")
                .pathsToMatch(paths)
                .build();

    }
}
