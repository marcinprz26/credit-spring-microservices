package pl.marcin.creditservice.exceptions;

public class ParameterValidationException extends RuntimeException {

    public ParameterValidationException() {
        super("One of the input parameters is incorrect");
    }

    public ParameterValidationException(String message) {
        super(message);
    }
}
