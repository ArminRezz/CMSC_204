/**
 * Exception class to represent the error when passwords do not match.
*/
public class UnmatchedException extends Exception {
    public UnmatchedException() {
        super("Passwords do not match");
    }
}