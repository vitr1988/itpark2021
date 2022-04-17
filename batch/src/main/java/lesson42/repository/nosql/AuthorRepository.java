package lesson42.repository.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;
import lesson42.model.nosql.Author;

public interface AuthorRepository extends MongoRepository<Author, String> {
}
