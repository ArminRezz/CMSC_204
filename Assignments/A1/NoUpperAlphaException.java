/**
 * Exception class to represent the error when a password does not contain an uppercase alphabetic character.
*/
public class NoUpperAlphaException extends Exception {
    public NoUpperAlphaException() {
        super("The password must contain at least one uppercase alphabetic character");
    }
}