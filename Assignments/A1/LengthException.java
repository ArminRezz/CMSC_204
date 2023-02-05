/**
 * 
 * Exception class for handling the password length requirements. This exception
 * is thrown when a password with less than 6 characters is entered.
 */
public class LengthException extends Exception {
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
}
