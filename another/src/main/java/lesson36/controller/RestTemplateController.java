package lesson36.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class RestTemplateController {

    private final RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping("/test")
    public String getInfo() {
        return restTemplate.getForObject(UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8080)
                .path("/test")
                .queryParam("initiator", applicationName)
                .build(Map.of()), String.class);
    }
}
