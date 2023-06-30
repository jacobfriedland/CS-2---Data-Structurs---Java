class Circle extends Shape
{
	double radius;

	// Constructor
	public Circle(String name, double radius)
	{
		// Call parent constructor
		super(name);

		// Initialize other fields
		this.radius = radius;
	}

	public void Print()
	{
		System.out.println("Circle with radius " + radius);
	}

	public double GetArea()
	{
		return Math.PI * radius * radius;
	}
}
