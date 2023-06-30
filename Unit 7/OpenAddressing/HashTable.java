class HashTable
{
	// Class fields
	Node nodes[];
	int size;
	int length;
	
	// Constants
	static final double max_load_factor = 0.7;
	static final int initial_size = 5;

	public HashTable()
	{
		size = initial_size;
		nodes = new Node[size];
	}

	// Return the data associated with the given key, or null if the key
	// is not present in the hash table.
	public Object Search(Object key)
	{
		// Obtain index for the key
		int index = key.hashCode() % size;

		// NEW - Traverse collision list
		while (nodes[index] != null)
		{
			// Check this key
			if (nodes[index].key.equals(key))
				return nodes[index].data;

			// Next position
			index = (index + 1) % size;
		}

		// Not found
		return null;
	}


	// Insert a pair key-data into the hash table.
	public void Insert(Object key, Object data)
	{
		// Check if the table must grow
		double load_factor = (double) length / size;
		if (load_factor > max_load_factor)
			Grow();
		
		// Create node
		Node node = new Node(key, data);

		// Get index for the key
		int index = key.hashCode() % size;

		// NEW - Find available slot
		while (nodes[index] != null)
			index = (index + 1) % size;

		// NEW - Insert it
		nodes[index] = node;

		// Update length
		length++;
	}

	// Grow the hash table. All nodes must be repositioned according to
	// their new hash indices based on the new table size.
	void Grow()
	{
		// Message
		System.out.println("Growing hash table");

		// Save old nodes and table size
		int old_size = size;
		Node old_nodes[] = nodes;

		// Create new table
		size = size * 2;
		length = 0;
		nodes = new Node[size];

		// Re-insert all nodes
		for (int i = 0; i < old_size; i++)
			if (old_nodes[i] != null)
				Insert(old_nodes[i].key, old_nodes[i].data);
	}


	// Remove the element with the given key from the hash table. If the
	// given key is not present, an exception is thrown.
	public void Remove(Object key)
	{
		// Get index for the key
		int index = key.hashCode() % size;

		// NEW - Search for key
		while (nodes[index] != null && !nodes[index].key.equals(key))
			index = (index + 1) % size;

		// NEW - Not found
		if (nodes[index] == null)
			throw new RuntimeException("Key not found");

		// NEW - Remove entry and go to next position
		nodes[index] = null;
		length--;
		index = (index + 1) % size;

		// NEW - Re-insert all elements in the collision list
		while (nodes[index] != null)
		{
			// Read node and remove it
			Node node = nodes[index];
			nodes[index] = null;
			length--;

			// Re-insert
			Insert(node.key, node.data);

			// Next
			index = (index + 1) % size;
		}
	}

	// Print associated data for all nodes
	public void Print()
	{
		// Traverse table
		for (int i = 0; i < size; i++)
			if (nodes[i] != null)
				System.out.println(nodes[i].data);
	}

	public int GetLength()
	{
		return length;
	}
}

