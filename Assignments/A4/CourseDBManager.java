import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * CourseDBManager class implements CourseDBManagerInterface and provides
 * functionality to add, retrieve, and display CourseDBElements.
 * This class uses CourseDBStructure to store CourseDBElements.
 *
 * @author Armin Reziayan-Nojani
 */

public class CourseDBManager implements CourseDBManagerInterface {

    private CourseDBStructure courseDB;

    /**
     * Constructs a new CourseDBManager object with a default capacity of 20.
     */
    public CourseDBManager() {
        courseDB = new CourseDBStructure(20);
    }

    /**
     * Adds a new CourseDBElement to the database.
     *
     * @param id         the course ID of the CourseDBElement.
     * @param crn        the CRN of the CourseDBElement.
     * @param credits    the number of credits of the CourseDBElement.
     * @param roomNum    the room number of the CourseDBElement.
     * @param instructor the instructor name of the CourseDBElement.
     */
    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
        courseDB.add(element);
    }

    /**
     * Retrieves a CourseDBElement from the database by its CRN.
     *
     * @param crn the CRN of the CourseDBElement to retrieve.
     * @return the CourseDBElement with the specified CRN, or null if it does not exist.
     */
    @Override
    public CourseDBElement get(int crn) {
        try {
            return courseDB.get(crn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Reads a file of CourseDBElements and adds them to the database.
     *
     * @param input the input file to read CourseDBElements from.
     * @throws FileNotFoundException if the input file cannot be found or read.
     */
    @Override
    public void readFile(File input) throws FileNotFoundException {
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            String id = tokens[0];
            int crn = Integer.parseInt(tokens[1]);
            int credits = Integer.parseInt(tokens[2]);
            String roomNum = tokens[3];
            String instructor = tokens[4];
            add(id, crn, credits, roomNum, instructor);
        }
        scanner.close();
    }

    /**
     * Retrieves an ArrayList of all CourseDBElements in the database.
     *
     * @return an ArrayList of all CourseDBElements in the database.
     */
    @Override
    public ArrayList<String> showAll() {
        return courseDB.showAll();
    }
}
