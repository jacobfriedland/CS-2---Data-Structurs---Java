class Deque
{
	int left;
	int length;
	int size;
	Object[] items;

	public Deque()
	{
		size = 2;
		items = new Object[2];
	}

	int GetPhysicalIndex(int index)
	{
		// NOTE: Adding '+size' allows us to pass negative values to
		// 'index'.
		return (left + index + size) % size;
	}

	void Grow()
	{
		// Allocate new items
		Object new_items[] = new Object[size * 2];

		// Copy old items
		for (int i = 0; i < length; i++)
			new_items[i] = items[GetPhysicalIndex(i)];

		// Duplicate size
		size = size * 2;

		// Discard old items
		items = new_items;

		// Adjust boundaries
		left = 0;
	}

	void ExpandLeft(int index)
	{
		// Shift left
		for (int i = 0; i < index; i++)
			items[GetPhysicalIndex(i - 1)] = items[GetPhysicalIndex(i)];

		// Move 'left' boundary
		left = GetPhysicalIndex(-1);
	}

	void ExpandRight(int index)
	{
		// Shift right
		for (int i = length - 1; i >= index; i--)
			items[GetPhysicalIndex(i + 1)] = items[GetPhysicalIndex(i)];
	}

	public Object Get(int index)
	{
		return index >= 0 || index < length ?
				items[GetPhysicalIndex(index)] :
				null;
	}

	public void Insert(int index, Object item)
	{
		// Check index
		if (index < 0 || index > length)
			throw new IllegalArgumentException("Invalid index");

		// Grow if needed
		if (length == size)
			Grow();

		// Expand left or right
		if (index < length / 2)
			ExpandLeft(index);
		else
			ExpandRight(index);
		
		// Set new item
		items[GetPhysicalIndex(index)] = item;

		// One more item
		length++;
	}
	
	public void Print()
	{
		// Message
		System.out.println("Content:");

		// Traverse
		for (int i = 0; i < length; i++)
			System.out.println(Get(i));
	}

}
