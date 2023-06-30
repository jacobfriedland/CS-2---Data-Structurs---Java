class Test
{
	public static void main(String args[])
	{
		// Create linked list
		LinkedList linked_list = new LinkedList();

		// Insert elements at the end
		linked_list.Insert(Integer.valueOf(10));
		linked_list.Next();
		linked_list.Insert(Integer.valueOf(11));
		linked_list.Next();
		linked_list.Insert(Integer.valueOf(12));

		// Insert more element before the previous ones
		linked_list.Head();
		linked_list.Insert(Integer.valueOf(13));
		linked_list.Next();
		linked_list.Insert(Integer.valueOf(14));
		linked_list.Next();
		linked_list.Insert(Integer.valueOf(15));

		// Print
		linked_list.Print();
	}
}
