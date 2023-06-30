class MergeSort
{
	static void Merge(int v[], int left1, int right1, int left2, int right2)
	{
		// Number of elements
		int n1 = right1 - left1 + 1;
		int n2 = right2 - left2 + 1;
		
		// Allocate sub-arrays
		int v1[] = new int[n1];
		int v2[] = new int[n2];

		// Copy first sub-array
		for (int i = 0; i < n1; i++)
			v1[i] = v[i + left1];

		// Copy second sub-array
		for (int i = 0; i < n2; i++)
			v2[i] = v[i + left2];


		// Indices
		int index = left1;
		int index1 = 0;
		int index2 = 0;

		// Merge
		while (true)
		{
			// Check for empty sub-arrays
			boolean empty1 = index1 == n1;
			boolean empty2 = index2 == n2;

			// If both are empty, done
			if (empty1 && empty2)
				break;

			// Condition to grab element from first sub-array:
			//   a) Second sub-array is empty, or
			//   b) First sub-array is not empty and its current
			//	element is less than the current element in
			//	second sub-array.
			if (empty2 || (!empty1 && v1[index1] < v2[index2]))
			{
				// Grab from first sub-array
				v[index] = v1[index1];
				index1++;
			}
			else
			{
				// Grab from second sub-array
				v[index] = v2[index2];
				index2++;
			}
			
			// Next
			index++;
		}
	}

	static void SortRecursive(int v[], int left, int right)
	{
		// Arrays with 0 or 1 elements are already sorted
		if (left >= right)
			return;

		// Middle point
		int middle = (left + right) / 2;

		// Sort recursively
		SortRecursive(v, left, middle);
		SortRecursive(v, middle + 1, right);

		// Merge
		Merge(v, left, middle, middle + 1, right);
	}

	public static void Sort(int v[])
	{
		SortRecursive(v, 0, v.length - 1);
	}
}
