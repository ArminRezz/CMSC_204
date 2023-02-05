/**
 * Exception to indicate that a password cannot contain more than two of the
 * same character in sequence.
 */
public class InvalidSequenceException extends Exception {
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
}