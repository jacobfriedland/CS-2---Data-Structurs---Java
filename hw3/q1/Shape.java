abstract class Shape
{
	private String name;

	public Shape(String name)
	{
		this.name = name;
	}
	
	public void Print()
	{
		System.out.print("This shape is a: " + name);
	}
	
	public abstract double GetArea();

	public int compareTo(Object other)
	{
		Shape other_shape = (Shape) other;

		double this_area = GetArea();
		double other_area = other_shape.GetArea();

		if (this_area < other_area)
			return -1;
	

		else if (this_area > other_area)
			return 1;

		else
			return 0;
	}
}
