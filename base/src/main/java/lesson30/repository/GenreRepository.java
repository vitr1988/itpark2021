package lesson30.repository;

import lesson30.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface GenreRepository extends JpaRepository<Genre, String> {
}
