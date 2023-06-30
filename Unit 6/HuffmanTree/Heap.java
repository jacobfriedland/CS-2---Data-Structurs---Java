class Heap
{
	Vector vector;

	int Parent(int index)
	{
		return (index - 1) / 2;
	}

	int Left(int index)
	{
		return index * 2 + 1;
	}

	int Right(int index)
	{
		return index * 2 + 2;
	}

	void Float(int index)
	{
		// Ignore if it's the root
		if (index == 0)
			return;

		// Check if current item is greater than parent
		int parent = Parent(index);
		if (Get(index).compareTo(Get(parent)) > 0)
		{
			vector.Swap(index, parent);
			Float(parent);
		}
	}

	void Sink(int index)
	{
		// Get left and right indexes
		int left = Left(index);
		int right = Right(index);

		// Assume maximum value is current node
		int max = index;

		// Update maximum to left child if necessary
		if (left < GetLength() && Get(left).compareTo(Get(max)) > 0)
			max = left;

		// Update maximum value to right child if necessary
		if (right < GetLength() && Get(right).compareTo(Get(max)) > 0)
			max = right;

		// Check if max is not current
		if (max != index)
		{
			// Swap current with max and continue sinking
			vector.Swap(index, max);
			Sink(max);
		}
	}

	public Heap()
	{
		vector = new Vector();
	}

	public int GetLength()
	{
		return vector.GetLength();
	}

	public Comparable Get(int index)
	{
		return (Comparable) vector.Get(index);
	}

	public void Insert(Comparable item)
	{
		// Add it at the end
		vector.Add(item);

		// Float it
		Float(vector.GetLength() - 1);
	}

	public Comparable ExtractMax()
	{
		// Check if there are any elements left
		if (GetLength() == 0)
			throw new RuntimeException("Heap is empty");

		// Get root
		Comparable max_object = Get(0);

		// Swap root and last and remove last
		vector.Swap(0, GetLength() - 1);
		vector.Remove(GetLength() - 1);

		// Sink root
		Sink(0);

		// Return extracted element
		return max_object;
	}
}

