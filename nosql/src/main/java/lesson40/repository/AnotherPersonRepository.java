package lesson40.repository;

import lesson40.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@ConditionalOnProperty(value = "application.nosql.type", havingValue = "redis")
public class AnotherPersonRepository {

    private final KeyValueOperations keyValueTemplate;

    public List<Person> findAll() {
        return (List<Person>) keyValueTemplate.findAll(Person.class);
    }

    public Person save(Person email) {
        return keyValueTemplate.insert(email);
    }
}
