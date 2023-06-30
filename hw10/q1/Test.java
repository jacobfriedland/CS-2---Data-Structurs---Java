class Test
{
        public static void main(String args[])
        {
                // Create graph
                Graph graph = new Graph(5);

                // Add edges
                graph.AddEdge(0, 1);
                graph.AddEdge(2, 1);
                graph.AddEdge(3, 2);
                graph.AddEdge(1, 3);
                graph.AddEdge(1, 4);

		int values1[] = {0, 1, 3, 2, 1};
		int values2[] = {0, 1, 2, 3};
		int values3[] = {3, 2, 1, 4};

		boolean result1 = graph.HasPath(values1);
		boolean result2 = graph.HasPath(values2);
		boolean result3 = graph.HasPath(values3);
		
		if (result1 == false)
			System.out.println("Path does not exist for abdcb");
		else
			System.out.println("Path exists for abdcb");

		if (result2 == false)
			System.out.println("Path does not exist for abcd");
		else
			System.out.println("Path exists for abcd");

		if (result3 == false)
			System.out.println("Path does not exist for dcbe");
		else
			System.out.println("Path exists for dcbe");
	}
}
