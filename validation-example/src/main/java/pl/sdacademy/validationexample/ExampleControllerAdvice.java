package pl.sdacademy.validationexample;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Collection;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExampleControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleRuntimeException(RuntimeException e) {
        return "Wyrzucony został wyjątek typu RuntimeException, wiadomość: " + e.getMessage();
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Collection<PropertyValidationError> handleConstraintViolationException(ConstraintViolationException e) {
        return e.getConstraintViolations()
                .stream()
                .map(cv -> new PropertyValidationError(cv.getPropertyPath().toString(), cv.getMessage()))
                .collect(Collectors.toList());
        // return "Błąd walidacji";
    }
}
