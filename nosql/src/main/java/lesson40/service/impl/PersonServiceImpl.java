package lesson40.service.impl;

import lesson40.model.Person;
import lesson40.repository.PersonRepository;
import lesson40.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
@ConditionalOnProperty(value = "application.nosql.type", havingValue = "redis")
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
//        return StreamSupport.stream(personRepository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
        return personRepository.findAll();
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }
}
