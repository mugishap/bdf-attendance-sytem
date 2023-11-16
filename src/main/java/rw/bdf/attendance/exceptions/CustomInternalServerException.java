package rw.bdf.attendance.exceptions;

public class CustomInternalServerException extends RuntimeException {
    public CustomInternalServerException(String message) {
        super(message);
    }
}