class Test
{
	public static void main(String args[])
	{
		Deque deque = new Deque();

		// Add element on the right
		deque.Insert(0, Integer.valueOf(0));
		deque.Insert(1, Integer.valueOf(1));
		deque.Insert(2, Integer.valueOf(2));
		deque.Insert(3, Integer.valueOf(3));

		// Add element on the left
		deque.Insert(0, Integer.valueOf(4));
		deque.Insert(0, Integer.valueOf(5));
		deque.Insert(0, Integer.valueOf(6));
		deque.Insert(0, Integer.valueOf(7));

		// Print
		deque.Print();
	}
}
