class HuffmanTree
{
	Node root;
	Node leaf_nodes[];

	public void CreateLeafNodes(String ascii_text)
	{
		// Array of leaf nodes indexed by ASCII code
		leaf_nodes = new Node[256];

		// Parse text
		for (int i = 0; i < ascii_text.length(); i++)
		{
			// Gte ASCII code for current character
			int ascii_code = ascii_text.charAt(i);

			// Create node if it doesn't exist
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
			// Extrac 2 nodes with minimum frequency
			Node left = (Node) heap.ExtractMax();
			Node right = (Node )heap.ExtractMax();

			// Create new node and make if the root for now
			root = new Node(0);
			root.left = left;
			root.right = right;
			root.frequency = left.frequency + right.frequency;

			// Insert new node in the heap
			heap.Insert(root);	
		}

		// Assign Huffman code
		root.SetHuffmanCode("");
	}
	
	public String Encode(String ascii_text)
	{
		// Initialize result
		String result = "";

		// Traverse text
		for (int i = 0; i < ascii_text.length(); i++)
		{
			// Get ASCII code
			int ascii_code = ascii_text.charAt(i);

			// Check if character is supported
			if (leaf_nodes[ascii_code] == null)
				throw new RuntimeException("Character not supported: " + 
							ascii_text.charAt(i));

			// Get Huffman code
			String huffman_code = leaf_nodes[ascii_code].huffman_code;

			// Append to result
			result += huffman_code;
		}
		return result;
	}

	public String Decode(String huffman_code)
	{
		Node node = root;

		String result = "";

		for (int i = 0; i < huffman_code.length(); i++)
		{	
			char data = huffman_code.charAt(i);
			if (huffman_code.charAt(i) != '0' && huffman_code.charAt(i) != '1')
				throw new RuntimeException("Wrong character observed");
			if (data == '0')
				node = node.left;
			else
				node = node.right;

			if (node.ascii_code > 0)
			{
				result += (char) node.ascii_code;
				node = root;
			}
		}
		return result;
	}
}

































