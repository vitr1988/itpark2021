package lesson30.repository;

import lesson30.model.Book;
import lesson30.repository.dto.BookParamDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("select b from Book b " +
            "join fetch b.author a " +
            "join fetch b.genre g " +
            "left join fetch b.comments " +
            "where (:#{#paramDto.bookId} is null or b.id = :#{#paramDto.bookId}) and " +
            "(:#{#paramDto.isbn} is null or b.isbn = :#{#paramDto.isbn}) and " +
            "(:#{#paramDto.name} is null or lower(b.name) like CONCAT('%', :#{#paramDto.name} ,'%')) and " +
            "(:#{#paramDto.authorId} is null or a.id = :#{#paramDto.authorId}) and " +
            "(:#{#paramDto.genreCode} is null or g.code = :#{#paramDto.genreCode})")
    List<Book> getByParams(@NotNull BookParamDto paramDto);
}
