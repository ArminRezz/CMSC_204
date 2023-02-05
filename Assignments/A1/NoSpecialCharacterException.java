/**
 * Exception class to represent the error when a password does not contain a special character.
*/
public class NoSpecialCharacterException extends Exception {
    public NoSpecialCharacterException() {
        super("The password must contain at least one special character");
    }
}