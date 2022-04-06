package lesson39.service;

import lesson18.dto.Person;

public interface PersonService {

    Person getByName(String name);

    String getName();
}
