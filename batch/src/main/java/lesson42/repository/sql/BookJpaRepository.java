package lesson42.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import lesson42.model.sql.Book;

public interface BookJpaRepository extends JpaRepository<Book, Long> {

}