package lesson40.service;

import lesson40.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> findAll();

    void save(Person person);
}
