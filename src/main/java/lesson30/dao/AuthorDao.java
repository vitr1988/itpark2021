package lesson30.dao;

import lesson30.model.Author;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

public interface AuthorDao {
    List<Author> findAll();
    Optional<Author> getById(long authorId);
    Author save(@Valid Author author);
    void deleteById(long authorId);
    void delete(@Valid Author author);
}
