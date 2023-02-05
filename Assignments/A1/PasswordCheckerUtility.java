import java.util.ArrayList;

public class PasswordCheckerUtility {

	/**
	 * Returns an ArrayList of invalid passwords from a given ArrayList of
	 * passwords. A password is considered invalid if it does not pass the
	 * {@link #isValidPassword(String)} method. Each invalid password in the
	 * returned ArrayList is accompanied by the error message for why it is invalid.
	 * 
	 * @param passwordsArray ArrayList of passwords to be checked for validity
	 * @return ArrayList of invalid passwords along with their error messages
	 * @throws Exception If any of the individual passwords are invalid and throw an
	 *                   Exception
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwordsArray) {
		ArrayList<String> invalidPasswords = new ArrayList<>();
		for (String password : passwordsArray) {
			try {
				isValidPassword(password);
			} catch (Exception e) {
				invalidPasswords.add(password + " " + e.getMessage());
			}
		}
		return invalidPasswords;
	}

	/**
	 * Throws an UnmatchedException if the two given passwords do not match.
	 * 
	 * @param password        The first password to be compared
	 * @param passwordConfirm The second password to be compared
	 * @throws UnmatchedException If the two passwords do not match
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}

	/**
	 * Returns true if the two given passwords match, and false otherwise.
	 * 
	 * @param password        The first password to be compared
	 * @param passwordConfirm The second password to be compared
	 * @return true if the two passwords match, false otherwise
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}

	/**
	 * Throws a LengthException if the given password is less than 6 characters
	 * long.
	 * 
	 * @param password The password to be checked for length
	 * @return true if the password is at least 6 characters long, false otherwise
	 * @throws LengthException If the password is less than 6 characters long
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() < 6) {
			throw new LengthException();
		}
		return true;
	}

	/**
	 * Validates if the password contains at least one uppercase alphabetic
	 * character.
	 * 
	 * @param password the password string to be validated
	 * @return true if the password contains at least one uppercase alphabetic
	 *         character, false otherwise
	 * @throws NoUpperAlphaException if the password does not contain at least one
	 *                               uppercase alphabetic character
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		if (!password.matches(".*[A-Z].*")) {
			throw new NoUpperAlphaException();
		}
		return true;
	}

	/**
	 * This method checks if a given password contains at least one lowercase
	 * character.
	 * 
	 * @param password the password string to be checked
	 * @return true if the password contains at least one lowercase character, false
	 *         otherwise
	 * @throws NoLowerAlphaException if the password does not contain a lowercase
	 *                               character
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		if (!password.matches(".*[a-z].*")) {
			throw new NoLowerAlphaException();
		}
		return true;
	}

	/**
	 * This method checks if a given password contains at least one digit.
	 * 
	 * @param password the password string to be checked
	 * @return true if the password contains at least one digit, false otherwise
	 * @throws NoDigitException if the password does not contain a digit
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		if (!password.matches(".*\\d.*")) {
			throw new NoDigitException();
		}
		return true;
	}

	/**
	 * This method checks if a given password contains at least one special
	 * character.
	 * 
	 * @param password the password string to be checked
	 * @return true if the password contains at least one special character, false
	 *         otherwise
	 * @throws NoSpecialCharacterException if the password does not contain a
	 *                                     special character
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
			throw new NoSpecialCharacterException();
		}
		return true;
	}

	/**
	 * This method checks if a given password does not contain three or more
	 * identical characters in sequence.
	 * 
	 * @param password the password string to be checked
	 * @return true if the password does not contain three or more identical
	 *         characters in sequence, false otherwise
	 * @throws InvalidSequenceException if the password contains three or more
	 *                                  identical characters in sequence
	 */
	public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
		for (int i = 0; i < password.length() - 2; i++) {
			if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
				throw new InvalidSequenceException();
			}
		}
		return true;
	}

	/**
	 * This method checks if a given password is valid.
	 * 
	 * @param password the password string to be checked
	 * @return true if the password is valid, false otherwise
	 * @throws Exception if the password is invalid
	 */
	public static boolean isValidPassword(String password) throws Exception {
		if (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password)
				&& hasSpecialChar(password) && NoSameCharInSequence(password)) {
			return true;
		}
		return false;
	}

	/**
	 * This method checks if the given password is considered weak.
	 * 
	 * A password is considered weak if its length is greater than or equal to 6 and less than or equal to 9.
	 * 
	 * @param passwordString the password string to be checked
	 * @return true if the password is weak, false otherwise
	 * @throws WeakPasswordException if the password is considered weak
	 */
	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException {
			if (!(passwordString.length() < 6 || passwordString.length() > 9)) {
				throw new WeakPasswordException();
			}
			return false;
		}
}