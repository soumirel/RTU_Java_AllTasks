package rtu.task9;

public class InvalidTINException extends RuntimeException {
    public InvalidTINException(String errorMessage) {
        super(errorMessage);
    }
}
