package lesson42.repository.nosql;

import org.springframework.data.mongodb.repository.MongoRepository;
import lesson42.model.nosql.Comment;

public interface CommentRepository extends MongoRepository<Comment, String> {
}
