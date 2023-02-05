/**
 * Exception class to represent the error when a password does not contain a lowercase alphabetic character.
*/
public class NoLowerAlphaException extends Exception {
	public NoLowerAlphaException() {
		super("The password must contain at least one lowercase alphabetic character");
	}
}