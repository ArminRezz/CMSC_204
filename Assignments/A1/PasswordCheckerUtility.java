import java.util.ArrayList;

public class PasswordCheckerUtility {
	
    public PasswordCheckerUtility() {}
    
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

    public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
        if (!password.equals(passwordConfirm)) {
            throw new UnmatchedException();
        }
    }

    public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
        return password.equals(passwordConfirm);
    }

    public static boolean isValidLength(String password) throws LengthException {
        if (password.length() < 6) {
            throw new LengthException();
        }
        return true;
    }

    public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
        if (!password.matches(".*[A-Z].*")) {
            throw new NoUpperAlphaException();
        }
        return true;
    }

    public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
        if (!password.matches(".*[a-z].*")) {
            throw new NoLowerAlphaException();
        }
        return true;
    }

    public static boolean hasDigit(String password) throws NoDigitException {
        if (!password.matches(".*\\d.*")) {
            throw new NoDigitException();
        }
        return true;
    }

    public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new NoSpecialCharacterException();
        }
        return true;
    }

    public static boolean NoSameCharInSequence(String password) throws InvalidSequenceException {
        for (int i = 0; i < password.length() - 2; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i + 1) == password.charAt(i + 2)) {
                throw new InvalidSequenceException();
            }
        }
        return true;
    }

    public static boolean isValidPassword(String password) throws Exception {
        if (isValidLength(password) && hasUpperAlpha(password) && hasLowerAlpha(password) && hasDigit(password) && hasSpecialChar(password) && NoSameCharInSequence(password)) {
            return true;
        }
        return false;
    }

	public static boolean isWeakPassword(String passwordString) throws WeakPasswordException {
		if(passwordString.length() <= 6 || passwordString.length() > 9) {
			throw new WeakPasswordException();
		}
		return false;
	}
}