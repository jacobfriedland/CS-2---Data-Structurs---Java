class LinkedList
{
	Node head;
	Node current;
	Node previous;

	// Return the data associated with the current element, or null if the
	// current element is past-the-end.
	public Object Get()
	{
		return current != null ? current.GetData() : null;
	}

	// Go to the next element if the current element is not past-the-end.
	public void Next()
	{
		if (current != null)
		{
			previous = current;
			current = current.next;
		}
	}

	// Go back to the first element
	public void Head()
	{
		previous = null;
		current = head;
	}

	// Insert a new element before the current element, or at the end if
	// the current element is past-the-end.
	public void Insert(Object data)
	{
		// Create new node
		Node node = new Node(data);

		// Set 'next' reference of new node
		node.next = current;

		// Set 'next' reference for previous node. Treat the special
		// case where the current node is the head of the list.
		if (current == head)
			head = node;
		else
			previous.next = node;
		
		// Update current node
		current = node;
	}

	// Remove the current element in the list, and set the current element
	// to the followig element.
	public void Remove()
	{
		// Past-the-end is an invalid position for this operation
		if (current == null)
			throw new RuntimeException("Invalid position to remove");

		// Remove element. Consider special case where the current
		// element is the head.
		if (current == head)
			head = current.next;
		else
			previous.next = current.next;

		// Move current element
		current = current.next;
	}

	public void Print()
	{
		// Traverse list
		for (Head(); Get() != null; Next())
			System.out.println(Get());
	}
}
