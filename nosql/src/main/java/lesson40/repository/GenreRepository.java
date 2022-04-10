package lesson40.repository;

import lesson40.model.Genre;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.mongodb.repository.MongoRepository;

@ConditionalOnProperty(value = "application.nosql.type", havingValue = "mongo", matchIfMissing = true)
public interface GenreRepository extends MongoRepository<Genre, String> {
}
