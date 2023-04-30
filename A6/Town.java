import java.util.ArrayList;

/**
 * 
 * The Town class represents a town that has a name and a list of adjacent
 * towns.
 */
public class Town implements Comparable<Town> {

	private String name;
	private ArrayList<Town> adjacentTowns;

	/**
	 * 
	 * Constructs a new Town object with the given name and an empty list of
	 * adjacent towns.
	 * 
	 * @param name the name of the town.
	 */
	public Town(String name) {
		this.name = name;
		this.adjacentTowns = new ArrayList<>();
	}

	/**
	 * 
	 * Constructs a new Town object that is a copy of the given template town.
	 * 
	 * @param templateTown the town to copy.
	 */
	public Town(Town templateTown) {
		this.name = templateTown.getName();
		this.adjacentTowns = new ArrayList<>(templateTown.getAdjacentTowns());
	}

	/**
	 * 
	 * Returns the name of the town.
	 * 
	 * @return the name of the town.
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * Sets the name of the town.
	 * 
	 * @param name the new name of the town.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * Returns the list of adjacent towns.
	 * 
	 * @return the list of adjacent towns.
	 */
	public ArrayList<Town> getAdjacentTowns() {
		return adjacentTowns;
	}

	/**
	 * 
	 * Sets the list of adjacent towns.
	 * 
	 * @param adjacentTowns the new list of adjacent towns.
	 */
	public void setAdjacentTowns(ArrayList<Town> adjacentTowns) {
		this.adjacentTowns = adjacentTowns;
	}

	/**
	 * 
	 * Adds a town to the list of adjacent towns.
	 * 
	 * @param town the town to add.
	 */
	public void addAdjacentTown(Town town) {
		adjacentTowns.add(town);
	}

	/**
	 * 
	 * Removes a town from the list of adjacent towns.
	 * 
	 * @param town the town to remove.
	 */
	public void removeAdjacentTown(Town town) {
		adjacentTowns.remove(town);
	}

	/**
	 * 
	 * Compares this town to another town based on their names.
	 * 
	 * @param o the town to compare to.
	 * @return a negative integer, zero, or a positive integer as this town is less
	 *         than, equal to, or greater than the specified town.
	 */
	@Override
	public int compareTo(Town o) {
		return this.name.compareTo(o.getName());
	}

	/**
	 * 
	 * Returns the name of the town.
	 * 
	 * @return the name of the town.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * 
	 * Returns the hash code of the town based on its name.
	 * 
	 * @return the hash code of the town.
	 */
	@Override
	public int hashCode() {
		return name.hashCode();
	}

	/**
	 * 
	 * Checks whether this town is equal to another object based on their names.
	 * 
	 * @param obj the object to compare to.
	 * @return true if the objects are equal, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Town)) {
			return false;
		}
		Town other = (Town) obj;
		return this.name.equals(other.getName());
	}
}