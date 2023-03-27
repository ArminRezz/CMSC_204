import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * CourseDBStructure is a class that implements the CourseDBStructureInterface.
 * It represents the structure of a database that contains CourseDBElements. It
 * is implemented using a hash table data structure, where each element is
 * inserted into a linked list at a specific index. It provides the ability to
 * add, get, and show all elements, as well as getting the size of the table.
 */
public class CourseDBStructure implements CourseDBStructureInterface {
	private int tableSize;
	private List<CourseDBElement>[] hashTable;

	/**
	 * Constructs a CourseDBStructure object with a given table size.
	 *
	 * @param n the table size
	 */
	public CourseDBStructure(int n) {
		int size = (int) (n / 1.5);
		tableSize = nextPrime(size);
		hashTable = new LinkedList[tableSize];
		for (int x = 0; x < tableSize; x++) {
			hashTable[x] = new LinkedList<CourseDBElement>();
		}
	}

	/**
	 * Constructs a CourseDBStructure object with a given file name and table size.
	 *
	 * @param s    the file name
	 * @param size the table size
	 */
	public CourseDBStructure(String s, int size) {
		tableSize = size;
		hashTable = new LinkedList[tableSize];
		for (int x = 0; x < tableSize; x++) {
			hashTable[x] = new LinkedList<CourseDBElement>();
		}
	}

	/**
	 * Adds a CourseDBElement to the database structure.
	 *
	 * @param element the CourseDBElement to add
	 */
	public void add(CourseDBElement element) {
		int index = Integer.toString(element.getCRN()).hashCode() % tableSize;
		if (hashTable[index].isEmpty()) {
			hashTable[index].add(element);
		} else {
			for (CourseDBElement e : hashTable[index]) {
				if (e.getCRN() == element.getCRN()) {
					hashTable[index].set(0, element);
				}
			}
		}
	}

	/**
	 * Gets a CourseDBElement from the database structure based on its CRN.
	 *
	 * @param crn the CRN of the element to get
	 * @return the CourseDBElement with the given CRN
	 * @throws IOException if the element is not found
	 */
	public CourseDBElement get(int crn) throws IOException {
		int hashCode = Integer.toString(crn).hashCode();
		int index = hashCode % tableSize;
		if (hashTable[index] == null) {
			throw new IOException();
		}
		for (CourseDBElement e : hashTable[index]) {
			if (e.getCRN() == crn) {
				return e;
			}
		}
		throw new IOException();
	}

	/**
	 * Returns an ArrayList containing all the CourseDBElements in the database
	 * structure.
	 *
	 * @return an ArrayList containing all the CourseDBElements in the database
	 *         structure
	 */
	public ArrayList<String> showAll() {
		ArrayList<String> courseList = new ArrayList<>();
		for (List<CourseDBElement> list : hashTable) {
			if (list != null) {
				for (CourseDBElement x : list) {
					courseList.add(x.toString());
				}
			}
		}
		return courseList;
	}

	/**
	 * Gets the size of the table.
	 *
	 * @return the size of the table
	 */
	public int getTableSize() {
		return tableSize;
	}

	private boolean isPrime(int n) {
		if (n <= 1) {
			return false;
		}
		for (int x = 2; x < n; x++) {
			if (n % x == 0) {
				return false;
			}
		}
		return true;
	}

	private int nextPrime(int n) {
		while (!isPrime(n) || n % 4 != 3) {
			n++;
		}
		return n;
	}
}
