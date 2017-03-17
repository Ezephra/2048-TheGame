package be.kdg.spel.model;

/**
 * @author Elias & Boyan
 */
public class SpelException extends RuntimeException {
    public SpelException(String message) {
        super(message);
    }

    public SpelException(Throwable cause) {
        super(cause);
    }
}
