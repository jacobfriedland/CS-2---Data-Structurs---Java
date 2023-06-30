class Test
{
	public static void main(String args[])
	{
		Heap heap = new Heap();
		heap.Insert(Integer.valueOf(10));
		heap.Insert(Integer.valueOf(1));
		heap.Insert(Integer.valueOf(5));
		heap.Insert(Integer.valueOf(3));
		heap.Insert(Integer.valueOf(6));

		// Extract elements
		while (heap.GetLength() > 0)
		{
			Integer value = (Integer) heap.ExtractMax();
			System.out.println(value);
		}
	}
}
