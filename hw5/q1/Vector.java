class Vector
{
        int length;
	int size;
        Object items[];

        public Vector()
        {
                size = 2;
                items = new Object[2];
        }

        void Resize(int new_size)
        {

		if (new_size < size)
			System.out.println("Shrinking capacity to " + new_size + " elements");
		else
			System.out.println("Growing capacity to " + new_size + " elements");
		
		size = new_size;		

                // Allocate new items
                Object new_items[] = new Object[size];

                // Copy old items into new array
                for (int i = 0; i < length; i++)
                        new_items[i] = items[i];

                // Discard old items
                items = new_items;
        }
	
	public void Insert(int index, Object item)
        {
                // Check valid index
                if (index < 0 || index > length)
                {
                        System.out.println("Invalid index");
                        return;
                }

                // Grow if necessary
                if (length == size)
                        Resize(length * 2);

                // Shift elements to the right
                for (int i = length - 1; i>= index; i--)
                        items[i+1] = items [i];

                // Insert new element
                items[index] = item;

                // One more item inserted
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
                // Check for valid index
                if (index < 0 || index >= length)
                {
                        System.out.println("Invalid index");
                        return;
                }

                // Message
                System.out.println("Removing " + items[index]);


    	        // Shift elements
                for (int i = index + 1;  i < length; i++)
                        items[i-1] = items[i];

                // Clear removed element 
                items[length - 1] =  null;

                // One less item present
                length--;		
	
		if (length < size / 2)
		{
			Resize(size / 2);
		}
	
	
	
        }

        public int GetLength()
        {
                return length;
        }

        public Object Get(int index)
        {
                return index >= 0 && index < length ? items[index] : null;
        }

        public void Print()
        {
                // Message
                System.out.println("Content:");

                // Traverse
                for (int i = 0; i < length; i++)
                        System.out.println(items[i]);
        }

        public void Swap(int index1, int index2)
        {
                Object temp = items[index1];
                items[index1] = items[index2];
                items[index2] = temp;
        }
}

