package lesson42.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import lesson42.model.sql.Author;

public interface AuthorJpaRepository extends JpaRepository<Author, Long> {
}
