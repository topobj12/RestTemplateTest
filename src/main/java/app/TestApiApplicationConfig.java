package app;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import app.client.OriginalClientHttpRequestFactory;

@WebAppConfiguration
public class TestApiApplicationConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().detectRequestFactory(false)
                .requestFactory(OriginalClientHttpRequestFactory.class).build();
    }

}
