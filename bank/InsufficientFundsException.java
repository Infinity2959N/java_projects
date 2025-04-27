package bank;

/**
 * Exception thrown when attempting to withdraw more money than is available in an account.
 */
public class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}