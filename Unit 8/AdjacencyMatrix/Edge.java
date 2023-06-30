class Edge
{
	// Flag indicating whether the edge is present
	public boolean present = false;

	// Weight of the edge. Ignored if 'present' is false.
	public int weight;

	// The following fields are populated by the Floyd-Warshall algorithm,
	// and they are meaning even when field 'present' is false.

	// In the 'Edge' object at position {i, j}, field "distance" contains
	// the distance of the shortest path between 'i' and 'j', or infinity
	// if there is no path between 'i' and 'j'.
	public int distance = Integer.MAX_VALUE;
	
	// In the 'Edge' object at position {i, j}, field "parent" indicates
	// that, in order to go from vertex 'i' to vertex 'j' through the
	// shortest path, we must first attempt to reach vertex 'parent'.
	public int parent = -1;
}
