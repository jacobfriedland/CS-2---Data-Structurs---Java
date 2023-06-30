import java.util.ArrayDeque;
import java.util.Queue;

class Graph
{
	int size;
	Vertex vertices[];

	public Graph(int size)
	{
		// Save size
		this.size = size;

		// Allocate array of vertices
		vertices = new Vertex[size];

		// Create vertices
		for (int i = 0; i < size; i++)
			vertices[i] = new Vertex();
	}

	public void AddEdge(int source, int target)
	{
		// Create edge
		Edge edge = new Edge(target);

		// Add it to adjacency list
		edge.next = vertices[source].edge;
		vertices[source].edge = edge;
	}

	public void AddUndirectedEdge(int source, int target)
	{
		AddEdge(source, target);
		AddEdge(target, source);
	}

	public int GetSize()
	{
		return size;
	}

	public void Print()
	{
		System.out.println("** Graph **");
		for (int i = 0; i < size; i++)
		{
			// Title
			System.out.println("Vertex " + i + ":");

			// Print properties
			System.out.println("  Parent: " + vertices[i].parent);
			System.out.println("  Distance: " + vertices[i].distance);
			System.out.println("  Time in: " + vertices[i].time_in);
			System.out.println("  Time out: " + vertices[i].time_out);

			// Print edges
			System.out.println("  Edges:");
			for (Edge edge = vertices[i].edge; edge != null; edge = edge.next)
				System.out.println("    " + i + " -> " + edge.target);
		}
	}

	public void BFS(int start)
	{
		// Initialize
		for (int i = 0; i < size; i++)
		{
			vertices[i].color = Vertex.WHITE;
			vertices[i].distance = Integer.MAX_VALUE;
			vertices[i].parent = -1;
		}

		// Initialize start vertex
		vertices[start].color = Vertex.GRAY;
		vertices[start].distance = 0;

		// Insert start vertex in queue
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(start);

		// Process queue
		while (queue.peek() != null)
		{
			// Extract vertex from queue
			int source = queue.remove();

			// Traverse adjacency list
			for (Edge edge = vertices[source].edge; edge != null; edge = edge.next)
			{
				int target = edge.target;
				if (vertices[target].color == Vertex.WHITE)
				{
					// Update target vertex
					vertices[target].color = Vertex.GRAY;
					vertices[target].parent = source;
					vertices[target].distance = vertices[source].distance + 1;

					// Enqueue target vertex
					queue.add(target);
				}
			}

			// Finish processing vertex
			vertices[source].color = Vertex.BLACK;
		}
	}

	void PrintShortestPath(int source, int target)
	{
		if (source == target)
		{
			System.out.print(source);
		}
		else if (vertices[target].parent == -1)
		{
			System.out.print("unreachable");
		}
		else
		{
			PrintShortestPath(source, vertices[target].parent);
			System.out.print(" -> " + target);
		}
	}

	// Visit vertex 'source' for the first time in a DFS. This function takes
	// the curent logical time as an input, and returns the updated logical
	// time after visiting the vertex.
	int DFSVisit(int source, int time)
	{
		// Color source vertex gray
		vertices[source].time_in = time++;  // Post-increment
		vertices[source].color = Vertex.GRAY;

		// Traverse adjacency list
		for (Edge edge = vertices[source].edge; edge != null; edge = edge.next)
		{
			// Get target vertex
			int target = edge.target;

			// Visit target if not visited yet
			if (vertices[target].color == Vertex.WHITE)
			{
				vertices[target].parent = source;
				time = DFSVisit(target, time);
			}
		}

		// Color source vertex black
		vertices[source].color = Vertex.BLACK;
		vertices[source].time_out = time++;

		// Return updated time
		return time;
	}

	public void DFS(int start)
	{
		// Initialize all verteces
		for (int i = 0; i < size; i++)
		{
			vertices[i].color = Vertex.WHITE;
			vertices[i].parent = -1;
			vertices[i].time_in = -1;
			vertices[i].time_out = -1;
		}

		// Recursive call to source
		DFSVisit(start, 0);
	}

}
