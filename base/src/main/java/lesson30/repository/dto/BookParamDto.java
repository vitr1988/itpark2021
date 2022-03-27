package lesson30.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookParamDto {
    private Long bookId;
    private String isbn;
    private String name;
    private Long authorId;
    private String genreCode;

    public BookParamDto(Long authorId) {
        this.authorId = authorId;
    }

    public BookParamDto(String genreCode) {
        this.genreCode = genreCode;
    }
}
