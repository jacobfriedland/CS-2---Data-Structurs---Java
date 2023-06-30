class DoublyLinkedList
{
	Node head;
	Node tail;
	Node current;

	public void Head()
	{
		current = head;
		current.previous = null;
	}

	public void Tail()
	{
		current = tail;
	}

	public void Next()
	{
		if (current != null)
		{
			current = current.next;
		}
	}

	public void Previous()
	{
		if (current == null)
			current = tail;
		else if (current != head)
			current = current.previous;
	}

	public Object Get()
	{
		return current == null ? null : current.GetData();
	}	

	public void Insert(Object data)
	{
		Node node = new Node(data);

		if (current == null)
			node.previous = tail;
		else
			node.previous = current.previous;

		node.next = current;

		if (current == head)
			head = node;
		else if (current == null)
			tail.next = node;
		else
			current.previous.next = node;

		if (current == null)
			tail = node;
		else
			current.previous = node;

		current = node;
	}

	public void Print()
        {
                for (Head(); Get() != null; Next())
                        System.out.println(Get());
        }			
}



















