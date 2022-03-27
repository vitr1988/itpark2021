package lesson29.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("spring.application")
public class SpringProperties {

    private String name;
    private String titleAndBanner;

}
