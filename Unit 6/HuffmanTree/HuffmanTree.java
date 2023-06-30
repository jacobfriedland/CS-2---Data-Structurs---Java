class HuffmanTree
{
	Node root;
	Node leaf_nodes[];

	public void CreateLeafNodes(String text)
	{
		// Array of leaf nodes indexed by ASCII code
		leaf_nodes = new Node[256];

		// Parse text
		for (int i = 0; i < text.length(); i++)
		{
			// Get ASCII code for current character
			int ascii_code = text.charAt(i);

			// Create node if it does not exist
			if (leaf_nodes[ascii_code] == null)
				leaf_nodes[ascii_code] = new Node(ascii_code);

			// Increment frequency
			leaf_nodes[ascii_code].frequency++;
		}
	}

	public void BuildTree()
	{
		// Create heap
		Heap heap = new Heap();

		// Insert all leaf nodes
		for (int i = 0; i < 256; i++)
			if (leaf_nodes[i] != null)
				heap.Insert(leaf_nodes[i]);

		// Build tree
		while (heap.GetLength() > 1)
		{
			// Extract 2 nodes with minimum frequency
			Node left = (Node) heap.ExtractMax();
			Node right = (Node) heap.ExtractMax();

			// Create new node and make it the root for now
			root = new Node(0);
			root.left = left;
			root.right = right;
			root.frequency = left.frequency + right.frequency;

			// Insert new node in heap
			heap.Insert(root);
		}

		// Set Huffman codes
		root.SetHuffmanCode("");
	}

	public String Encode(String text)
	{
		// Result
		String result = "";

		// Traverse text
		for (int i = 0; i < text.length(); i++)
		{
			// Get ASCII code
			int ascii_code = text.charAt(i);

			// Check if character is supported
			if (leaf_nodes[ascii_code] == null)
				throw new RuntimeException("Character not supported: " + text.charAt(i));

			// Get Huffman code
			String huffman_code = leaf_nodes[ascii_code].huffman_code;

			// Add it
			result += huffman_code;

			// Message
			System.out.println(text.charAt(i) + " -> " + huffman_code);
		}

		// Result
		return result;
	}
}
