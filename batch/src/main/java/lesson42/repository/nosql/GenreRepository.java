package lesson42.repository.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;
import lesson42.model.nosql.Genre;

public interface GenreRepository extends MongoRepository<Genre, String> {
}
