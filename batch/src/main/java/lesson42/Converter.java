package lesson42;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EntityScan("lesson42.model.sql")
@EnableMongoRepositories
public class Converter {

    public static void main(String[] args) {
        SpringApplication.run(Converter.class, args);
    }
}
