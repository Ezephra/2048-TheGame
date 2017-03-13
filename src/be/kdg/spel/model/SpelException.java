package be.kdg.spel.model;

/**
 * Created by boyan on 12/03/2017.
 */
public class SpelException extends RuntimeException {
    public SpelException(String message) {
        super(message);
    }

    public SpelException(Throwable cause) {
        super(cause);
    }
}
