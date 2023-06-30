class Rectangle extends Shape
{
	double width;
	double height;

	// Constructor
	public Rectangle(String name, double width, double height)
	{
		// Call parent class contructor
		super(name);

		// Initialize other fields
		this.width = width;
		this.height = height;
	}

	public double GetArea()
	{
		return width * height;
	}
}
