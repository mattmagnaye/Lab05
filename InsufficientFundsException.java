/**
 * The InsufficientFundsException is thrown when there are not enough funds in the account to withdraw a requested amount.
 */
public class InsufficientFundsException extends Exception {
    /**
     * Constructs an InsufficientFundsException object with the given message.
     * @param message the message for the exception
     */
    public InsufficientFundsException(String message) {
        super(message);
    }
}
