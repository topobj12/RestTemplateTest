package app.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.net.URI;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import app.client.OriginalClientHttpRequestFactory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TestControllerTest {

    @Autowired
    RestTemplate restTemplate;

    @LocalServerPort
    String port;

    @Test
    public void testControllerCheck() {
        try {
            // url
            URI url = new URI("http://localhost:" + port + "/test");

            // 送信用body
            String body = "{\"test\":{\"key1\":\"val1\",\"key2\":\"val2\"}}";

            // header
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);

            // method
            HttpMethod method = HttpMethod.GET;

            // resuestEntity
            RequestEntity<String> request = new RequestEntity<String>(body, headers, method, url);

            // 実行
            ResponseEntity<String> response = restTemplate.exchange(request, String.class);

            // 確認
            assertThat(response.getBody()).isEqualTo(body);

        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(false);
        }
    }
    
    @TestConfiguration
    static class TestConfig {
        @Bean
        public RestTemplate restTemplate() {
            return new RestTemplateBuilder().requestFactory(OriginalClientHttpRequestFactory.class).build();
        }
    }

}
