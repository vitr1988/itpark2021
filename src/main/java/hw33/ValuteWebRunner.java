package hw33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"hw26.service", "hw33"})
public class ValuteWebRunner {

    public static void main(String[] args) {
        SpringApplication.run(ValuteWebRunner.class, args);
    }
}
