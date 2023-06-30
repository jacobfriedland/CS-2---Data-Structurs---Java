class Node implements Comparable
{
	public int frequency;
	public Node left;
	public Node right;
	public int ascii_code;
	public String huffman_code;

	public Node(int ascii_code)
	{
		this.ascii_code = ascii_code;
	}

	public int compareTo(Object other)
	{
		Node other_node = (Node) other;

		// Inverted comparison to make max-heap
		// behave as it were a min-heap
		if (frequency < other_node.frequency)
			return 1;
		else if (frequency > other_node.frequency)
			return -1;
		else
			return 0;
	}

	public void SetHuffmanCode(String huffman_code)
	{
		// Save code
		this.huffman_code = huffman_code;

		// Set code for the left child recuresively
		if (left != null)
			left.SetHuffmanCode(huffman_code + "0");

		// Set code for the right child recursively
		if (right != null)
			right.SetHuffmanCode(huffman_code + "1");
	}




}
