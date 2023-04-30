import java.util.Objects;

public class Road implements Comparable<Road> {
	private Town source;
	private Town destination;
	private int weight;
	private String name;

	/**
	 * Creates a new road with the given source, destination, weight, and name.
	 * 
	 * @param source      the source town for the road
	 * @param destination the destination town for the road
	 * @param weight      the weight of the road
	 * @param name        the name of the road
	 */
	public Road(Town source, Town destination, int weight, String name) {
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		this.name = name;
	}

	/**
	 * Creates a new road with the given source, destination, and name, and a weight
	 * of 1.
	 * 
	 * @param source      the source town for the road
	 * @param destination the destination town for the road
	 * @param name        the name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this(source, destination, 1, name);
	}

	/**
	 * Returns whether the given town is contained within this road.
	 * 
	 * @param town the town to check for containment
	 * @return true if the given town is either the source or the destination of
	 *         this road, false otherwise
	 */
	public boolean contains(Town town) {
		return source.equals(town) || destination.equals(town);
	}

	/**
	 * Returns the name of this road.
	 * 
	 * @return the name of this road
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the destination town of this road.
	 * 
	 * @return the destination town of this road
	 */
	public Town getDestination() {
		return destination;
	}

	/**
	 * Returns the source town of this road.
	 * 
	 * @return the source town of this road
	 */
	public Town getSource() {
		return source;
	}

	/**
	 * Returns the weight of this road.
	 * 
	 * @return the weight of this road
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Returns a string representation of this road.
	 * 
	 * @return a string representation of this road
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Compares this road to the given road based on their names.
	 * 
	 * @param o the road to compare to
	 * @return a negative integer, zero, or a positive integer as this road is less
	 *         than, equal to, or greater than the given road
	 */
	@Override
	public int compareTo(Road o) {
		return this.name.compareTo(o.getName());
	}

	/**
	 * Returns whether this road is equal to the given object.
	 * 
	 * @param o the object to compare to
	 * @return true if this road is equal to the given object, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof Road)) {
			return false;
		}
		Road road = (Road) o;
		return (source.equals(road.getSource()) && destination.equals(road.getDestination()))
				|| (source.equals(road.getDestination()) && destination.equals(road.getSource()));
	}

	/**
	 * Returns a hash code value for this road.
	 * @return the hash code value for this road
	 */
	@Override
	public int hashCode() {
		return Objects.hash(source, destination, weight, name);
	}
}
