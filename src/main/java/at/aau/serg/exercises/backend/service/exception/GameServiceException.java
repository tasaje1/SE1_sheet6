package at.aau.serg.exercises.backend.service.exception;

public class GameServiceException extends Exception {
    public GameServiceException() {
        super();
    }

    public GameServiceException(String message) {
        super(message);
    }
}
