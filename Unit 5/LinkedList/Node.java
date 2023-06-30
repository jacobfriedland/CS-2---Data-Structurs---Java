class Node
{
	// Public reference to next node
	public Node next;

	// Private data field
	Object data;

	Node(Object data)
	{
		this.data = data;
	}

	public Object GetData()
	{
		return data;
	}
}

