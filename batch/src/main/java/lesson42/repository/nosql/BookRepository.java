package lesson42.repository.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;
import lesson42.model.nosql.Book;

public interface BookRepository extends MongoRepository<Book, String> {
}