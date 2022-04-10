package lesson40;

import lesson40.model.Person;
import lesson40.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@Slf4j
@SpringBootApplication(exclude = MongoAutoConfiguration.class)
public class KeyValueRunner {

    public static void main(String[] args) {
        final ConfigurableApplicationContext applicationContext = SpringApplication.run(KeyValueRunner.class, args);
        final PersonService personService = applicationContext.getBean(PersonService.class);
        personService.save(new Person(1, "Vitalii Ivanov"));
        personService.save(new Person(2, "Sergey Petrov"));
        personService.save(new Person(3, "Nina Sidorova"));
        log.info("All persons {}", personService.findAll());
    }
}
