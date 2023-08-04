package pl.kurs.exchangerateapponspringbootgit.exceptions;

public class InvalidInputDataException extends Exception{

    public InvalidInputDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidInputDataException(String message) {
        super(message);
    }
}
