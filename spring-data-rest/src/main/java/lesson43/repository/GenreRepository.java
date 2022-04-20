package lesson43.repository;

import lesson43.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Альтернатива свагеру - http://localhost:8085/api
 */
@RepositoryRestResource(path = "genres")
public interface GenreRepository extends JpaRepository<Genre, String> {
}
