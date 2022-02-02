package lesson25.spring.service.impl;

import lesson25.spring.service.PersonService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary
//@Component
public class AnotherPersonServiceImpl implements PersonService {

    @Override
    public void print() {
        System.out.println("New person service print");
    }
}
