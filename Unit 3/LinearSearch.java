class LinearSearch
{
	// Search value 'x' in sorted array 'v'. If the value is found, return
	// its index in the array. If not found, return -1.
	static int Search(int v[], int x)
	{
		// Iterate through array
		for (int i = 0; i < v.length; i++)		// A
			if (v[i] == x)				// B
				return i;			// C

		// Not found
		return -1;					// D
	}

	public static void main(String args[])
	{
		int v[] = {1, 3, 4, 7, 8, 10, 11, 20};
		int index = Search(v, 11);
		System.out.println(index);
	}
}

