package lesson25.spring.dao.impl;

import lesson25.spring.dao.PersonDao;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDaoImpl implements PersonDao {

    @Override
    public void save() {
        System.out.println("Person has been successfully saved");
    }
}
