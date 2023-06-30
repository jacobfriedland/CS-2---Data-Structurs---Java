class Test
{
	public static void main(String args[])
	{
		Graph graph1 = new Graph(6);

		Graph graph2 = new Graph(6);

		Graph graph3 = new Graph(6);
		
		graph1.AddUndirectedEdge(0, 1);
		graph1.AddUndirectedEdge(1, 2);
		graph1.AddUndirectedEdge(1, 4);
		graph1.AddUndirectedEdge(3, 4);
		graph1.AddUndirectedEdge(4, 5);
		
		graph2.AddUndirectedEdge(0, 1);
		graph2.AddUndirectedEdge(1, 4);
		graph2.AddUndirectedEdge(3, 4);
		graph2.AddUndirectedEdge(2, 5);

		graph3.AddUndirectedEdge(0, 1);
		graph3.AddUndirectedEdge(0, 3);
		graph3.AddUndirectedEdge(1, 2);
		graph3.AddUndirectedEdge(1, 5);
		graph3.AddUndirectedEdge(2, 5);
		graph3.AddUndirectedEdge(1, 3);
		graph3.AddUndirectedEdge(4, 4);

		if (graph1.IsConnected())
			System.out.println("Connected");
		else
			System.out.println("Not connected");

		if (graph2.IsConnected())
			System.out.println("Connected");
		else
			System.out.println("Not connected");
		
		if (graph3.IsConnected())
			System.out.println("Connected");
		else
			System.out.println("Not connected");
	}
}
