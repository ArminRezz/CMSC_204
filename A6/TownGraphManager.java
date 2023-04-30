
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class TownGraphManager implements TownGraphManagerInterface {
	private Graph graph = new Graph();

	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1  
	 * @param town2 name of town 2  
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		return (graph.addEdge(new Town(town1), new Town(town2), weight, roadName) != null);
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1  
	 * @param town2 name of town 2  
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	public String getRoad(String town1, String town2) {
		return ((Road) graph.getEdge(new Town(town1), new Town(town2))).getName();
	}

	/**
	 * Adds a town to the graph
	 * @param v the town's name   
	 * @return true if the town was successfully added, false if not
	 */
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	public Town getTown(String name) {
		return new Town(name);
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}
	
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 
	 * @param town2 name of town 2  
	 * @return true if the road is in the graph, false if not
	 */
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	public ArrayList<String> allRoads() {
		ArrayList<Road> roads = new ArrayList<Road>(graph.edgeSet());
		ArrayList<String> roadsList = new ArrayList<String>();
		for (Road r : roads) {
			roadsList.add(r.getName());
		}
		Collections.sort(roadsList);
		return roadsList;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1  
	 * @param town2 name of town 2  
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	public boolean deleteRoadConnection(String town1, String town2, String roadName) {
		Town t1 = new Town(town1);
		Town t2 = new Town(town2);
		for (Road road : graph.edgesOf(t1)) {
			if (road.getDestination().equals(t2) && road.getName().equals(roadName)) {
				return graph.removeEdge(t1, t2, road.getWeight(), roadName) != null;
			}
		}
		return false;
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town  
	 * @return true if the town was successfully deleted, false if not
	 */
	public boolean deleteTown(String v) {
		return graph.removeVertex(new Town(v));
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	public ArrayList<String> allTowns() {
		ArrayList<Town> towns = new ArrayList<>(graph.vertexSet());
		ArrayList<String> townsList = new ArrayList<>();
		for (Town town : towns) {
			townsList.add(town.getName());
		}
		Collections.sort(townsList);
		return townsList;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1   
	 * @param town2 name of town 2  
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	public ArrayList<String> getPath(String town1, String town2) {
		if (!graph.containsVertex(new Town(town1)) || !graph.containsVertex(new Town(town2))) {
			return new ArrayList<>();
		}
		ArrayList<String> path = graph.shortestPath(new Town(town1), new Town(town2));
		if (path == null || path.isEmpty()) {
			return new ArrayList<>();
		}
		return path;
	}

	// extra function added because FXMainPane requires it
	public void populateTownGraph(File file) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] tokens = line.split(",|;");
			String roadName = tokens[0];
			int weight = Integer.parseInt(tokens[1]);
			String town1Name = tokens[2];
			String town2Name = tokens[3];

			// Add the towns and road to the graph
			Town town1 = new Town(town1Name);
			Town town2 = new Town(town2Name);
			graph.addVertex(town1);
			graph.addVertex(town2);
			graph.addEdge(town1, town2, weight, roadName);
		}
		scanner.close();
	}

}