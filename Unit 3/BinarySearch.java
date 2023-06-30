class BinarySearch
{
	// Search value 'x' in sorted array 'v'. If the value is found, return
	// its index in the array. If not found, return -1.
	static int Search(int v[], int x)
	{
		// Initialize indices
		int left = 0;					// A
		int right = v.length - 1;			// B

		// Iterate
		while (left <= right)				// C
		{
			// Middle point
			int n = right - left + 1;		// D
			int middle = left + n / 2;		// E

			// Check element in the middle
			if (x == v[middle])			// F
				return middle;			// G

			// Go to left or right
			if (x < v[middle])			// H
				right = middle - 1;		// I
			else
				left = middle + 1;		// J
		}

		// Not found
		return -1;					// K
	}

	public static void main(String args[])
	{
		int v[] = {1, 3, 4, 7, 8, 10, 11, 20};
		int index = Search(v, 11);
		System.out.println(index);
	}
}
