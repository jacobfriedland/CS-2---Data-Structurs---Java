class QuickSort
{
	static void Swap(int v[], int index1, int index2)
	{
		int temp = v[index1];
		v[index1] = v[index2];
		v[index2] = temp;
	}

	static int Partition(int v[], int left, int right)
	{
		// Initial pivot target position
		int p = left;

		// Pivot value
		int pivot = v[right];

		// Traverse vector
		for (int now = left; now < right; now++)
		{
			if (v[now] < pivot)
			{
				Swap(v, now, p);
				p++;
			}
		}

		// Place pivot in target position
		Swap(v, right, p);

		// Return final pivot positon
		return p;
	}

	static void SortRecursive(int v[], int left, int right)
	{
		if (left < right)
		{
			int p = Partition(v, left, right);
			SortRecursive(v, left, p - 1);
			SortRecursive(v, p + 1, right);
		}
	}

	static void Sort(int v[])
	{
		SortRecursive(v, 0, v.length - 1);
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

