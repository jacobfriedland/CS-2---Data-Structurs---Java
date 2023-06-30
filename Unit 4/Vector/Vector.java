class Vector
{
	Object items[];
	int length;
	int size;

	void Grow()
	{
		// Duplicate size
		size = size * 2;

		// Allocate new items
		Object new_items[] = new Object[size];

		// Copy old items
		for (int i = 0; i < length; i++)
			new_items[i] = items[i];

		// Discard old items
		items = new_items;

		// Message
		System.out.println("Growing capacity to " + size + " elements");
	}

	public Vector()
	{
		size = 2;
		items = new Object[2];
	}

	public void Print()
	{
		// Message
		System.out.println("Content:");

		// Traverse
		for (int i = 0; i < length; i++)
			System.out.println(items[i]);
	}

	public void Insert(int index, Object item)
	{
		// Check index
		if (index < 0 || index > length)
		{
			System.out.println("Invalid index");
			return;
		}

		// Grow if necessary
		if (length == size)
			Grow();

		// Shift
		for (int i = length - 1; i >= index; i--)
			items[i + 1] = items[i];

		// Insert
		items[index] = item;

		// One more item
		length++;

		// Message
		System.out.println("Inserted " + item);
	}

	public void Add(Object item)
	{
		Insert(length, item);
	}

	public void Remove(int index)
	{
		// Check index
		if (index < 0 || index >= length)
		{
			System.out.println("Invalid index");
			return;
		}

		// Message
		System.out.println("Removing " + items[index]);

		// Shift
		for (int i = index; i < length - 1; i++)
			items[i] = items[i + 1];

		// One less item
		length--;
	}

	public Object Get(int index)
	{
		return index >= 0 && index < length ?
				items[index] :
				null;
	}

	public int GetLength()
	{
		return length;
	}

	public void Swap(int index1, int index2)
	{
		Object temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}
}
