package lesson39.dao;

import lesson18.dto.Person;

public interface PersonDao {

    Person findByName(String name);

    String getName();
}
