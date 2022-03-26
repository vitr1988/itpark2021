package hw33.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.net.URL;

@Data
@Component
@Validated
@ConfigurationProperties("application")
public class ApplicationProperties {

    private CbrProperties cbr;

    @Data
    public static class CbrProperties {
        @NotNull
        private URL location;
    }
}
