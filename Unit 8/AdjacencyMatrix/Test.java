class Test
{
	public static void main(String args[])
	{
		// Create graph
		Graph graph = new Graph(5);
		graph.AddEdge(0, 1, 3);
		graph.AddEdge(0, 2, 8);
		graph.AddEdge(0, 4, -4);
		graph.AddEdge(1, 3, 1);
		graph.AddEdge(1, 4, 7);
		graph.AddEdge(2, 1, 4);
		graph.AddEdge(3, 0, 2);
		graph.AddEdge(3, 2, -5);
		graph.AddEdge(4, 3, 6);

		// Run Floyd-Warshall and print
		graph.FloydWarshall();
		graph.Print();
	}
}
