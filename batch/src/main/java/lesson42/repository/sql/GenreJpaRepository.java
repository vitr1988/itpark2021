package lesson42.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import lesson42.model.sql.Genre;

public interface GenreJpaRepository extends JpaRepository<Genre, String> {
}
