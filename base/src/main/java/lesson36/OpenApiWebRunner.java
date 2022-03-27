package lesson36;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(title = "Open API", version = "1.0", description = "Documentation"),
        externalDocs = @ExternalDocumentation(url = "https://itpark.tech/", description = "More details")
)
public class OpenApiWebRunner {

    public static void main(String[] args) {
        SpringApplication.run(OpenApiWebRunner.class, args);
    }
}
