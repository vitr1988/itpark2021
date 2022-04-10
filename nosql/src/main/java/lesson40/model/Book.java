package lesson40.model;

import io.github.kaiso.relmongo.annotation.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

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
    private Genre genre;

}
