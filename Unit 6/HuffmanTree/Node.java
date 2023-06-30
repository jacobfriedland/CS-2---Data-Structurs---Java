class Node implements Comparable<Node>
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

	public int compareTo(Node other)
	{
		// We perform an inverted comparison to make the max-heap behave
		// as a min-heap.
		if (frequency > other.frequency)
			return -1;
		else if (frequency < other.frequency)
			return 1;
		else
			return 0;
	}

	public void SetHuffmanCode(String huffman_code)
	{
		// Save code
		this.huffman_code = huffman_code;

		// Set code for left child
		if (left != null)
			left.SetHuffmanCode(huffman_code + "0");

		// Set code for right child
		if (right != null)
			right.SetHuffmanCode(huffman_code + "1");
	}
}
