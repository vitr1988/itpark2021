package lesson42.model.nosql;

import io.github.kaiso.relmongo.annotation.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@Document(collection = "comment")
public class Comment {

    @Id
    private String id;

    @NotEmpty
    private String text;

    @ManyToOne
    private Book book;

    public Comment(String text) {
        this.text = text;
    }
}
