package lesson42.repository.sql;

import org.springframework.data.jpa.repository.JpaRepository;
import lesson42.model.sql.Comment;

public interface CommentJpaRepository extends JpaRepository<Comment, Long> {
}
