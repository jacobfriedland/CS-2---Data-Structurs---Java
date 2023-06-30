class SelectionSortGeneric
{
	static <T extends Comparable<T>> int GetMinIndex(T v[], int left, int right)
	{
		// Assume left
		int min_index = left;

		// Traverse
		for (int i = left + 1; i <= right; i++)
			if (v[i].compareTo(v[min_index]) < 0)
				min_index = i;

		// Return it
		return min_index;
	}

	static <T> void Swap(T v[], int index1, int index2)
	{
		T temp = v[index1];
		v[index1] = v[index2];
		v[index2] = temp;
	}

	static <T extends Comparable<T>> void Sort(T v[])
	{
		for (int i = 0; i < v.length - 1; i++)
		{
			// Get min index
			int min_index = GetMinIndex(v, i, v.length - 1);

			// Swap
			Swap(v, i, min_index);
		}
	}

	static <T> void Print(T v[])
	{
		for (int i = 0; i < v.length; i++)
			System.out.println(v[i]);
	}

	public static void main(String args[])
	{
		Integer v[] = { 5, 3, 12, 8, 1, 9 };
		Sort(v);
		Print(v);
	}
}


