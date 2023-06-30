class HashTable
{
        Node nodes[];
        int size;
        int length;

        static final double max_load_factor = 0.7;
        static final int initial_size = 5;

        public HashTable()
        {       
                size = initial_size;
                nodes = new Node[size];
        }

        // Return the data associated with the given key, or null if they key
        // is not present in the hash table.
        public Object Search(Object key)
        {       
                // Obtain index in the array for the key
                int index = Math.floorMod(key.hashCode(), size);
                
                // Traverse collision list
                for (Node node = nodes[index]; node != null; node = node.next)
                        if (key.equals(node.key))
                                return node.data;
                
                // Node found
                return null;
        }

        // Insert a pair key data into the hash table
        public void Insert(Object key, Object data)
        {       
                // Check if the node must grow
                double load_factor = (double) length / size;
                if (load_factor > max_load_factor)
                        Grow();
                
                // Create new node
                Node node = new Node(key, data);
                
                // Get index for the key
                int index = Math.floorMod(key.hashCode(), size);
                
                // Insert new node at the head at the collision list
                node.next = nodes[index];
                nodes[index] = node;

		length++;
        }

	void Grow()
        {       
                // Save old nodes and table size
                int old_size = size;
                Node old_nodes[] = nodes;
                
                // Create new array
		size = NextPrime(size * 2);
                nodes = new Node[size];
		System.out.println("Growing hash table to " + size + " entries");
                
                // Traverse old nodes
                for (int i = 0; i < old_size; i++)
                        while (old_nodes[i] != null)
			{
				Node node = old_nodes[i];
				old_nodes[i] = node.next;

				int index = node.key.hashCode() % size;
				node.next = nodes[index];
				nodes[index] = node;
			}
        }

        // Remove the element with the given key from the hash table
	// If the given key is not present, an exception is thrown
        public void Remove(Object key)
        {
                // Get index for the key
                int index = Math.floorMod(key.hashCode(), size);

                // Traverse collision list
                Node previous = null;
                Node node = nodes[index];
                while (node != null && !node.key.equals(key))
                {
                        previous = node;
                        node = node.next;
                }

                // Not found
                if (node == null)
                        throw new RuntimeException("Key not found");

                // Delete the node
                if (previous == null)
                        nodes[index] = node.next;
                else
                        previous.next = node.next;

                // Update length
                length--;
        }

	public void Print()
        {
                // Traverse table
                for (int i = 0; i < size; i++)
                        for (Node node = nodes[i]; node !=null; node = node.next)
                                System.out.println(node.data);
        }

        public int GetLength()
        {
                return length;
        }

	boolean IsPrime(int value)
	{
		for (int i = value-1; i > 1; i--)
			if (value % i ==0)
				return false;
		return true;	
	}

	int NextPrime(int value)
	{
		do
		{
			value++;
		} while (!IsPrime(value));

		return value;
	}
}



























