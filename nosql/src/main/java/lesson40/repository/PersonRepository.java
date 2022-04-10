package lesson40.repository;

import lesson40.model.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

import java.util.List;

@ConditionalOnProperty(value = "application.nosql.type", havingValue = "redis")
public interface PersonRepository extends KeyValueRepository<Person, Integer> {

    List<Person> findAll();
}
