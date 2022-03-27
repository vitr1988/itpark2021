package lesson32;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import lesson32.service.ServiceA;

@SpringBootApplication
public class EventRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(EventRunner.class, args);
        final ServiceA serviceA = applicationContext.getBean(ServiceA.class);
        serviceA.sendEvent("Здесь могла быть Ваша реклама!");
    }
}
