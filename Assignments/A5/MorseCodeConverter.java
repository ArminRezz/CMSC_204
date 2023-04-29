import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	private static MorseCodeTree tree = new MorseCodeTree();

	public MorseCodeConverter() {
		tree.buildTree();
	}

	public static String convertToEnglish(File codeFile) {
		String english = "";
		try {
			Scanner scanner = new Scanner(codeFile);
			String code = "";
			while (scanner.hasNextLine()) {
				code += (scanner.nextLine() + " "); // add space after each line
			}
			scanner.close();
			english = convertToEnglish(code);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(english);
		return english;
	}

	public static String convertToEnglish(String code) {
	    String[] codes = code.split("\\s{2}|/"); // split by two spaces or a forward slash
	    String english = "";
	    for (String c : codes) {
	        String[] letters = c.split(" "); // split by one space
	        for (String l : letters) {
	            String letter = tree.fetch(l);
	            if (letter != null) {
	                english += letter;
	            }
	        }
	        english += " "; // add a space between words
	    }
	    return english.trim(); // remove any leading/trailing spaces
	}

	public static String printTree() {
		ArrayList<String> list = new ArrayList<>();
		tree.LNRoutputTraversal(tree.getRoot(), list);
		return String.join(" ", list);
	}
}