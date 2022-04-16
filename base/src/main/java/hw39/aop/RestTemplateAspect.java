package hw39.aop;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class RestTemplateAspect {

    private final RestTemplate restTemplate;

    @Before("execution(* hw39.service.impl.CityDictionaryServiceImpl.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        final URI aspectUrl = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost")
                .port(8081)
                .path("/logger")
                .queryParam("method", joinPoint.getSignature().getName())
                .queryParam("params", Stream.of(joinPoint.getArgs()).map(Object::toString).collect(Collectors.joining(", ")))
                .build(Map.of());
        log.info("Передаем информацию, вызывая {}", aspectUrl);
        restTemplate.getForEntity(aspectUrl, Void.class);
    }

}
