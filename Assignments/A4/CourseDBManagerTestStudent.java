import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * This is the test file for the CourseDBManager which is implemented from the
 * CourseDBManagerInterface
 */
public class CourseDBManagerTestStudent {
	private CourseDBManagerInterface dataMgr = new CourseDBManager();

	/**
	 * Create an instance of CourseDBManager
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		dataMgr = new CourseDBManager();
	}

	/**
	 * Set dataMgr reference to null
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		dataMgr = null;
	}

	/**
	 * Test for the add method
	 */
	@Test
	public void testAddToDB() {
		try {
			dataMgr.add("CMSC301", 40763, 3, "AV102", "John Doe");
		} catch (Exception e) {
			fail("This should not have caused an Exception");
		}
	}

	/**
	 * Test for the showAll method
	 */
	@Test
	public void testShowAll() {
		dataMgr.add("CMSC301", 40763, 3, "AV102", "John Doe");
		dataMgr.add("CMSC341", 40767, 3, "AV104", "Jane Smith");
		dataMgr.add("MATH241", 40843, 4, "MTH0301", "Mark Johnson");
		ArrayList<String> list = dataMgr.showAll();
		assertEquals(list.get(0), "\nCourse:CMSC301 CRN:40763 Credits:3 Instructor:John Doe Room:AV102");
		assertEquals(list.get(1), "\nCourse:CMSC341 CRN:40767 Credits:3 Instructor:Jane Smith Room:AV104");
		assertEquals(list.get(2), "\nCourse:MATH241 CRN:40843 Credits:4 Instructor:Mark Johnson Room:MTH0301");
	}

	/**
	 * Test for the read method
	 */
	@Test
	public void testRead() {
		try {
			File inputFile = new File("Test2.txt");
			PrintWriter inFile = new PrintWriter(inputFile);
			inFile.println("CMSC301 40763 3 AV102 John Doe");
			inFile.print("MATH241 40843 4 MTH0301 Mark Johnson");

			inFile.close();
			dataMgr.readFile(inputFile);
			assertEquals("CMSC301", dataMgr.get(40763).getID());
			assertEquals("MATH241", dataMgr.get(40843).getID());
			assertEquals("AV102", dataMgr.get(40763).getRoomNum());
		} catch (Exception e) {
			fail("Should not have thrown an exception");
		}
	}
}
