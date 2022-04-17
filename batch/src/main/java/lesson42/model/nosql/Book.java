package lesson42.model.nosql;

import io.github.kaiso.relmongo.annotation.OneToMany;
import io.github.kaiso.relmongo.annotation.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
@Document(collection = "book")
public class Book {

    @Id
    private String id;

    @NotEmpty
    private String isbn;

    @NotEmpty
    private String name;

    @OneToOne
    private Author author;

    @OneToOne
    private Genre genre;

    @OneToMany
    private List<Comment> comments;

    public Book(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public String getAuthorId() {
        return author == null ? null : author.getId();
    }

    public String getGenreCode() {
        return genre == null ? null : genre.getCode();
    }
}
