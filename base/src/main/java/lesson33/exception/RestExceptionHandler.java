package lesson33.exception;

import lesson33.dto.error.ErrorType;
import lesson33.dto.error.RestApiErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.NotEmpty;
import java.nio.file.AccessDeniedException;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Разделитель в наименованиях свойств, проверяемых валидатором.
     */
    private static final String PROPERTY_SEPARATOR = ".";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(ErrorType.VALIDATION_FAILED);

        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            apiErrorDto.getError().addField(fieldName, errorMessage);
        });
        return new ResponseEntity<>(apiErrorDto, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
                                                                         HttpHeaders headers, HttpStatus status,
                                                                         WebRequest request) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(ErrorType.VALIDATION_FAILED.name(), ex.getMessage());
        return new ResponseEntity<>(apiErrorDto, headers, status);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(ErrorType.VALIDATION_FAILED);
        ex.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            apiErrorDto.getError().addField(fieldName, errorMessage);
        });
        return new ResponseEntity<>(apiErrorDto, headers, status);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingRequestHeaderException.class)
    public RestApiErrorDto handleValidationExceptions(MissingRequestHeaderException ex) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(ErrorType.VALIDATION_FAILED);
        apiErrorDto.getError().addField(ex.getHeaderName(), ex.getMessage());
        return apiErrorDto;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public RestApiErrorDto handleIllegalExceptions(IllegalArgumentException ex) {
        log.warn("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(ErrorType.VALIDATION_FAILED);
        apiErrorDto.getError().setMessage("Проверьте введенные данные");
        return apiErrorDto;
    }

//    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
//    @ExceptionHandler(Exception.class)
//    public RestApiErrorDto handleException(Exception ex) {
//        log.warn("Exception handled", ex);
//        return new RestApiErrorDto(ErrorType.INTERNAL_SERVER_ERROR, ex.getMessage());
//    }


//    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
//    @ExceptionHandler(TeapotClientException.class)
//    public void handleException(TeapotClientException ex) {
//        log.warn("Exception handled", ex);
//    }

    @ExceptionHandler(BeanCreationException.class)
    public ResponseEntity<RestApiErrorDto> handleException(BeanCreationException ex) {
        log.warn("Exception handled", ex);
        final Throwable cause = ex.getCause();
        if (cause != null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new RestApiErrorDto(ErrorType.INTERNAL_SERVER_ERROR, ex.getMessage()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public RestApiErrorDto handleException(ConstraintViolationException ex) {
        log.debug("Exception handled", ex);
        RestApiErrorDto apiErrorDto = new RestApiErrorDto(ErrorType.VALIDATION_FAILED);
        ex.getConstraintViolations().forEach(error -> {
            if (error.getConstraintDescriptor().getAnnotation().annotationType().equals(NotEmpty.class)) {
                apiErrorDto.getError().setCode(ErrorType.EMPTY_DATA.name());
            }
            final String propertyPath = error.getPropertyPath().toString();
            String fieldName = propertyPath.contains(PROPERTY_SEPARATOR) ? StringUtils.substringAfter(propertyPath, PROPERTY_SEPARATOR) : propertyPath;
            String errorMessage = error.getMessage();
            apiErrorDto.getError().addField(fieldName, errorMessage);
        });
        return apiErrorDto;
    }

    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ExceptionHandler(AccessDeniedException.class)
    public void handleException(AccessDeniedException ex) {
        log.warn("Exception handled", ex);
    }
}
