/**
 * The CourseDBElement class represents a single element of a course database. 
 * Stores information about a course, including its course ID, CRN, credits, 
 * room number, and instructor name.
 */
public class CourseDBElement implements Comparable<CourseDBElement> {

	private String courseId;
	private int crn;
	private int credits;
	private String roomNumber;
	private String instructorName;
	
	CourseDBElement() {
		this.courseId = null;
		this.crn = 0;
		this.credits = 0;
		this.roomNumber = null;
		this.instructorName = null;
	}

	public CourseDBElement(String courseId, int crn, int credits, String roomNumber, String instructorName) {
		this.courseId = courseId;
		this.crn = crn;
		this.credits = credits;
		this.roomNumber = roomNumber;
		this.instructorName = instructorName;
	}

	public String getID() {
		return courseId;
	}

	public void setID(String courseId) {
		this.courseId = courseId;
	}

	public int getCRN() {
		return crn;
	}

	public void setCRN(int crn) {
		this.crn = crn;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getRoomNum() {
		return roomNumber;
	}

	public void setRoomNum(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getInstructorName() {
		return instructorName;
	}

	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}

	@Override
	public int compareTo(CourseDBElement other) {
		if (this.getCRN() == other.getCRN()) {
			return 0;
		}
		return 1;
	}

	@Override
	public String toString() {
		return "\nCourse:" + courseId + " CRN:" + crn + " Credits:" + credits + " Instructor:" + instructorName
				+ " Room:" + roomNumber;
	}

}