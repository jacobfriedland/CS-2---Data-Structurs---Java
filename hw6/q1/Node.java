class Node
{
	public Node next;
	public Node previous;
	Object data;

	public Node(Object data)
	{
		this.data = data;
	}

	public Object GetData()
	{
		return data;
	}
}
