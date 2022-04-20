package lesson43.config;

import lombok.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.net.URL;

@Value
@Validated
@ConstructorBinding
@ConfigurationProperties("application")
public class ApplicationProperties {

    @NotNull
    private URL dependentModuleUrl;
}
