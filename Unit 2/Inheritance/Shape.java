abstract class Shape implements Printable, Comparable
{
	String name;

	// Constructor
	public Shape(String name)
	{
		this.name = name;
	}

	public void Print()
	{
		System.out.println("Shape " + name);
	}

	// Return the area of the shape. Every shape has an area, but
	// only a specific kind of shape knows how to calculate it.
	// Therefore we declare this as an abstract function, with
	// the following implications:
	//
	// 1) Class 'Shape' must be declared abstract, too
	//
	// 2) Class 'Shape' cannot be instantiated directly.
	//
	// 3) Every child class must implement function 'GetArea()'
	//
	public abstract double GetArea();

	public int compareTo(Object other)
	{
		// Cast (convert) argument 'other' into a reference of type 'Shape'
		Shape other_shape = (Shape) other;

		// Obtain shape areas
		double this_area = GetArea();
		double other_area = other_shape.GetArea();

		// Perform comparison
		if (this_area < other_area)
			return -1;
		else if (this_area > other_area)
			return 1;
		else
			return 0;
	}
}
