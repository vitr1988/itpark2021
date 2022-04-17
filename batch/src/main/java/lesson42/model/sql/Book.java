package lesson42.model.sql;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "BOOK")
@ToString(of = {"id", "isbn", "name", "author", "genre", "comments"})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "isbn", nullable = false, unique = true)
    private String isbn;

    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_code", nullable = false)
    private Genre genre;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public Book(String isbn, String name) {
        this.isbn = isbn;
        this.name = name;
    }

    public Long getAuthorId() {
        return author == null ? null : author.getId();
    }

    public String getGenreCode() {
        return genre == null ? null : genre.getCode();
    }
}
