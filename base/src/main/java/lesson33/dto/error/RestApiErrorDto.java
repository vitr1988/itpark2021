package lesson33.dto.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RestApiErrorDto {

    private ApiError error;

    public RestApiErrorDto(Enum<?> code) {
        this(code, null);
    }

    public RestApiErrorDto(Enum<?> code, String message) {
        this(code.name(), message);
    }

    public RestApiErrorDto(String code, String message) {
        this.error = new ApiError();
        this.error.setCode(code);
        this.error.setMessage(message);
    }
}
