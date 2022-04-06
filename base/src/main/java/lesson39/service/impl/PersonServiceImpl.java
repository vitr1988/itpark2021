package lesson39.service.impl;

import lesson18.dto.Person;
import lesson39.dao.PersonDao;
import lesson39.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Override
    public Person getByName(String name) {
        return personDao.findByName(name);
    }

    @Override
    public String getName() {
        return personDao.getName();
    }
}
