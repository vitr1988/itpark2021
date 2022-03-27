package hw22.exception;

/**
 * Исключение, возникаемое на случай, когда обязательный параметр appId не указан при запуске программы
 */
public class MandatoryParameterSkippedException extends RuntimeException {

    public MandatoryParameterSkippedException(String message) {
        super(message);
    }
}
