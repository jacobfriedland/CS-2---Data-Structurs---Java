class Test
{
	public static void main(String args[])
	{
		// Create graph
		Graph graph = new Graph(8);
		graph.AddUndirectedEdge(0, 1);
		graph.AddUndirectedEdge(0, 4);
		graph.AddUndirectedEdge(1, 5);
		graph.AddUndirectedEdge(2, 3);
		graph.AddUndirectedEdge(2, 5);
		graph.AddUndirectedEdge(2, 6);
		graph.AddUndirectedEdge(3, 6);
		graph.AddUndirectedEdge(3, 7);
		graph.AddUndirectedEdge(5, 6);
		graph.AddUndirectedEdge(6, 7);

		// Print it
		graph.Print();

		// Run BFS starting at vertex 1
		graph.BFS(1);

		// Print graph and shortest paths
		System.out.println("\n** Breadth-First Search **\n");
		for (int i = 0; i < graph.GetSize(); i++)
		{
			System.out.print("Shortest path from 1 to " + i + ": ");
			graph.PrintShortestPath(1, i);
			System.out.println();
		}

		// Create graph
		Graph graph2 = new Graph(6);
		graph2.AddEdge(0, 1);
		graph2.AddEdge(0, 4);
		graph2.AddEdge(0, 3);
		graph2.AddEdge(1, 4);
		graph2.AddEdge(3, 4);
		graph2.AddEdge(4, 2);
		graph2.AddEdge(4, 5);
		graph2.AddEdge(5, 3);

		// Run DFS starting at vertex 0
		graph2.DFS(0);

		// Print graph
		System.out.println("\n** Depth-First Search **\n");
		graph2.Print();
	}
}
