import java.util.*;

public class Graph implements GraphInterface<Town, Road> {
	HashMap<String, HashMap<String, Road>> matrix = new HashMap<String, HashMap<String, Road>>();
	private int[] distance;
	private String[] previous;
	private ArrayList<String> towns;
	

	/**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. 
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		try {
			return matrix.get((sourceVertex).getName()).get((destinationVertex).getName());
		} catch (Exception e) {
			return null;
		}
	}

	 /**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     */
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException("Source and destination vertices cannot be null.");
		}

		if (!matrix.containsKey(sourceVertex.getName()) || !matrix.containsKey(destinationVertex.getName())) {
			throw new IllegalArgumentException("Source and/or destination vertices not found in the graph.");
		}

		Road road = new Road(sourceVertex, destinationVertex, weight, description);
		matrix.get(sourceVertex.getName()).put(destinationVertex.getName(), road);
		matrix.get(destinationVertex.getName()).put(sourceVertex.getName(), road);

		return road;
	}

	/**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	public boolean addVertex(Town v) {
		if (v == null) {
			throw new NullPointerException();
		}
		if (matrix.containsKey(v.getName())) {
			return false;
		}
		matrix.put(v.getName(), new HashMap<String, Road>());
		matrix.get(v.getName()).put(v.getName(), null);
		return true;
	}

	 /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		if (matrix.containsKey(sourceVertex.getName()) && matrix.containsKey(destinationVertex.getName())) {
			return matrix.get(sourceVertex.getName()).get(destinationVertex.getName()) != null;
		}
		return false;
	}

    /**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	public boolean containsVertex(Town v) {
		return matrix.containsKey(v.getName());
	}

	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     *
     *
     * @return a set of the edges contained in this graph.
     */
	public Set<Road> edgeSet() {
		Set<Road> road = new HashSet<Road>();
		for (Map<String, Road> edges : matrix.values()) {
			for (Road roadEdge : edges.values()) {
				if (roadEdge != null) {
					road.add(roadEdge);
				}
			}
		}
		return road;
	}

	/**
     * Returns a set of all edges  
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	public Set<Road> edgesOf(Town vertex) {

		Town t = (Town) vertex;
		if (t == null) {
			throw new NullPointerException();
		}
		if (matrix.get(t.getName()) == null) {
			throw new IllegalArgumentException();
		}

		Set<Road> road = new HashSet<Road>(matrix.get(t.getName()).values());
		road.remove(null);
		return road;
	}

	 /**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (weight >= 0 && description != null) {
			Road road = matrix.get(sourceVertex.getName()).get(destinationVertex.getName());
			matrix.get(sourceVertex.getName()).put(destinationVertex.getName(), null);
			matrix.get(destinationVertex.getName()).put(destinationVertex.getName(), null);
			return road;
		}
		return null;
	}

	 /**
     * Removes the specified vertex from this graph including all its touching
     * edges if present. More formally, if the graph contains a vertex 
     * u such that u.equals(v), the call removes all edges
     * that touch u and then removes u itself. If no
     * such u is found, the call leaves the graph unchanged.
     * Returns true if the graph contained the specified vertex. (The
     * graph will not contain the specified vertex once the call returns).
     *
     * If the specified vertex is null returns false.
     *
     * @param v vertex to be removed from this graph, if present.
     *
     * @return true if the graph contained the specified vertex;
     * false otherwise.
     */
	public boolean removeVertex(Town v) {
		if (v == null || matrix.get(v.getName()) == null) {
			return false;
		}
		matrix.remove(v.getName());
		return true;
	}

	 /**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	public Set<Town> vertexSet() {
		Set<Town> road = new HashSet<Town>();
		for (String key : matrix.keySet()) {
			road.add(new Town(key));
		}
		return road;
	}

	/**
	 * Find the shortest path from the sourceVertex to the destinationVertex call
	 * the dijkstraShortestPath with the sourceVertex
	 * 
	 * @param sourceVertex      starting vertex
	 * @param destinationVertex ending vertex
	 * @return An arraylist of Strings that describe the path from sourceVertex to
	 *         destinationVertex
	 */
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		dijkstraShortestPath(sourceVertex);
		ArrayList<String> path = new ArrayList<>();
		int destIndex = towns.indexOf(destinationVertex.getName());
		while (previous[destIndex] != null) {
			path.add(destinationVertex.getName());
			destinationVertex = new Town(previous[destIndex]);
			destIndex = towns.indexOf(destinationVertex.getName());
		}
		path.add(destinationVertex.getName());
		Collections.reverse(path);
		ArrayList<String> finalPath = new ArrayList<>();
		for (int i = 0; i < path.size() - 1; i++) {
			String sourceName = path.get(i);
			String destinationName = path.get(i + 1);
			Road road = (Road) this.getEdge(new Town(sourceName), new Town(destinationName));
			String roadName = road.getName();
			int distance = road.getWeight();
			String pathString = sourceName + " via " + roadName + " to " + destinationName + " " + distance + " mi";
			finalPath.add(pathString);
		}
		return finalPath;
	}

	/**
	 * Dijkstra's Shortest Path Method. shortest distance from the sourceVertex to
	 * all the other vertices in the graph
	 * 
	 * @param sourceVertex the vertex to find shortest path from
	 * 
	 */
	public void dijkstraShortestPath(Town sourceVertex) {
		String source = sourceVertex.getName();
		List<Town> vertices = new ArrayList<>(vertexSet());
		towns = new ArrayList<>();
		ArrayList<String> unvisited = new ArrayList<>();
		for (Town t : vertices) {
			towns.add(t.getName());
			unvisited.add(t.getName());
		}

		distance = new int[towns.size()];
		previous = new String[towns.size()];

		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[towns.indexOf(source)] = 0;
		while (!unvisited.isEmpty()) {
			int shortestDist = Integer.MAX_VALUE;
			String shortestVertex = null;
			for (String v : unvisited) {
				if (distance[towns.indexOf(v)] < shortestDist) {
					shortestDist = distance[towns.indexOf(v)];
					shortestVertex = v;
				}
			}
			if (shortestVertex == null) {
				break;
			}
			unvisited.remove(shortestVertex);
			HashMap<String, Road> connected = matrix.get(shortestVertex);
			for (String key : connected.keySet()) {
				if (unvisited.indexOf(key) == -1 || connected.get(key) == null) {
					continue;
				}
				int ind = towns.indexOf(key);
				int curr = towns.indexOf(shortestVertex);
				int weight = connected.get(key).getWeight();
				if (distance[curr] + weight < distance[ind]) {
					distance[ind] = weight + distance[curr];
					previous[ind] = shortestVertex;
				}
			}
		}
	}

}