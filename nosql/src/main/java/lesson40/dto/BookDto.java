package lesson40.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {

    private String id;
    @NotEmpty
    @Size(min = 1, max = 120)
    private String isbn;
    @NotEmpty
    @Size(min = 1, max = 120)
    private String name;

    private String genreCode;
}
