/**
 * Exception class to represent the error when a password is considered weak.
*/
public class WeakPasswordException extends Exception {
    public WeakPasswordException() {
        super("The password is OK but weak - it contains fewer than 10 characters");
    }
}