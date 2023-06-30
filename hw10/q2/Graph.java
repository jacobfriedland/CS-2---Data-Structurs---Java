class Graph
{
        int size;
        Vertex vertices[];

        public Graph(int size)
        {
                // Save size
                this.size = size;

                // Initialize vertices
                vertices = new Vertex[size];
                for (int i = 0; i < size; i++)
                        vertices[i] = new Vertex();
        }

        public void AddEdge(int source, int target)
        {
                // Create edge
                Edge edge = new Edge(target);

                // Add it at the head of the adjacency list
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
                for (int i = 0; i < size; i ++)
                {       
                        // Title
                        System.out.println("Vertex " + i + ":");
                        
                        // Print edges
                        System.out.println("  Edges:");
                        for (Edge edge = vertices[i].edge; edge != null; edge = edge.next)
                                System.out.println("    " + i + " --> " + edge.target);
                }
        }
	
	void DiscoverVertex(int index)
	{
		Vertex vertex = vertices[index];

		if (vertex.discovered)
			return;
		
		vertex.discovered = true;

		for (Edge edge = vertices[index].edge; edge != null; edge = edge.next)
			DiscoverVertex(edge.target);		
	}

	public boolean IsConnected()
	{
		DiscoverVertex(0);
		
		for (int i = 0; i < size; i++)
		{	
		if (!vertices[i].discovered)
			return false;
		}
		return true;
	}
}





























