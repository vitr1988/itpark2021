package lesson29;

import lesson29.service.LocalizationService;
import lesson29.service.PropertyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PropertyRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext appContext = SpringApplication.run(PropertyRunner.class, args);
        final PropertyService propertyService = appContext.getBean(PropertyService.class);
        propertyService.printProperties();

        final LocalizationService localizationService = appContext.getBean(LocalizationService.class);
        System.out.println(localizationService.localize("locale.text", "реклама", 5));
    }
}
