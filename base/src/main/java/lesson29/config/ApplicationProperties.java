package lesson29.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Locale;

@Data
@Component
@Validated
@ConfigurationProperties("application")
public class ApplicationProperties {

    @NotNull
    private Integer value;

    private SettingsProperties setting;

    @Data
//    @ConfigurationProperties("settings")
    public static class SettingsProperties {
        private String name;
        private Resource file;
        private Locale locale;
        private List<String> lines;
    }
}
