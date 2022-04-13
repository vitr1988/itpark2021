package lesson41.repostiory;

import lesson41.model.Genre;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface GenreRepository extends ReactiveMongoRepository<Genre, String> {
}
