package lesson40.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GenreDto {
    @NotNull
    @Size(min = 1, max = 3)
    private String code;

    @NotNull
    @Size(min = 1, max = 120)
    private String name;
}
