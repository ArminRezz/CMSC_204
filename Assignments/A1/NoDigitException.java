/**
 * Exception class to represent the error when a password does not contain a digit.
*/
public class NoDigitException extends Exception {
    public NoDigitException() {
        super("The password must contain at least one digit");
    }
}