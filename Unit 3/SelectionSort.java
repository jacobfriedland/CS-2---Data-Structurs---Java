class SelectionSort
{
	static int GetMinIndex(int v[], int left, int right)
	{
		// Assume left
		int min_index = left;

		// Traverse
		for (int i = left + 1; i <= right; i++)
			if (v[i] < v[min_index])
				min_index = i;

		// Return it
		return min_index;
	}

	static void Swap(int v[], int index1, int index2)
	{
		int temp = v[index1];
		v[index1] = v[index2];
		v[index2] = temp;
	}

	static void Sort(int v[])
	{
		for (int i = 0; i < v.length - 1; i++)
		{
			// Get min index
			int min_index = GetMinIndex(v, i, v.length - 1);

			// Swap
			Swap(v, i, min_index);
		}
	}

	static void Print(int v[])
	{
		for (int i = 0; i < v.length; i++)
			System.out.println(v[i]);
	}

	public static void main(String args[])
	{
		int v[] = { 5, 3, 12, 8, 1, 9 };
		Sort(v);
		Print(v);
	}
}

