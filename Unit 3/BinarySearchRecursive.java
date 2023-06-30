class BinarySearchRecursive
{
	// Search value 'x' in sorted array 'v'. If the value is found, return
	// its index in the array. If not found, return -1.
	static int Search(int v[], int x, int left, int right)
	{
		// Number of elementsp
		int n = right - left + 1;
		if (n < 1)
			return -1;

		// Found in the middle
		int middle = left + n / 2;
		if (x == v[middle])
			return middle;

		// Check left side
		if (x < v[middle])
			return Search(v, x, left, middle - 1);

		// Check right side
		return Search(v, x, left + middle + 1, right);
	}

	static int Search(int v[], int x)
	{
		return Search(v, x, 0, v.length - 1);
	}

	public static void main(String args[])
	{
		int v[] = {1, 3, 4, 7, 8, 10, 11, 20};
		int index = Search(v, 11);
		System.out.println(index);
	}
}
