class Graph
{
	Edge edges[][];
	int size;

	public Graph(int size)
	{
		// Save size
		this.size = size;

		// Allocate array of edges
		edges = new Edge[size][size];

		// Create edges
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				edges[i][j] = new Edge();
	}

	public int GetSize()
	{
		return size;
	}

	public void AddEdge(int source, int target, int weight)
	{
		edges[source][target].present = true;
		edges[source][target].weight = weight;
	}

	public void Print()
	{
		// Title
		System.out.println("** Graph **");

		// Traverse edges
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				Edge edge = edges[i][j];
				System.out.println("Edge " + i + "/" + j);
				System.out.println("  present = " + edge.present);
				System.out.println("  weight = " + edge.weight);
				System.out.println("  distance = " + edge.distance);
				System.out.println("  parent = " + edge.parent);
			}
		}
	}

	public void FloydWarshall()
	{
		// Initialize
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				// Get edge
				Edge edge = edges[i][j];

				// If there is an edge, the distance is the weight
				if (edge.present)
				{
					edge.distance = edge.weight;
					edge.parent = i;
				}

				// A vertex has distance 0 to itself
				if (i == j)
					edge.distance = 0;
			}
		}
		
		// Run algorithm
		for (int k = 0; k < size; k++)
		{
			for (int i = 0; i < size; i++)
			{
				for (int j = 0; j < size; j++)
				{
					// Get edges
					Edge edge_ij = edges[i][j];
					Edge edge_ik = edges[i][k];
					Edge edge_kj = edges[k][j];

					// Update distance {i, j} if necessary
					if (edge_ij.distance > edge_ik.distance + edge_kj.distance &&
							edge_ik.distance != Integer.MAX_VALUE &&
							edge_kj.distance != Integer.MAX_VALUE)
					{
						edge_ij.distance = edge_ik.distance + edge_kj.distance;
						edge_ij.parent = edge_kj.parent;
					}
				}
			}
		}
	}
}
