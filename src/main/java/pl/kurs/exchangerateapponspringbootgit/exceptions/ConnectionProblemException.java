package pl.kurs.exchangerateapponspringbootgit.exceptions;

public class ConnectionProblemException extends Exception {

    public ConnectionProblemException(String message) {
        super(message);
    }

    public ConnectionProblemException(String message, Throwable cause) {
        super(message, cause);
    }

}
