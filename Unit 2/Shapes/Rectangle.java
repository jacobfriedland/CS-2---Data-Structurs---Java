class Rectangle
{
	double width;
	double height;
	String name;

	// Constructor
	public Rectangle(String name)
	{
		this.name = name;
	}

	public void SetDimensions(double w, double h)
	{
		width = w;
		height = h;
	}

	public double GetArea()
	{
		return width * height;
	}
}
