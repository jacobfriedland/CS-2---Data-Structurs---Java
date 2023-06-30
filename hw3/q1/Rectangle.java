class Rectangle extends Shape
{
	double width;
	double height;

	public Rectangle(String name, double width, double height)
	{
		super(name);
		this.width = width;
		this.height = height;
	}
	
	public void Print()
	{
		System.out.println("Rectangle has width: " + width + " and height: " + height);
	}

	public double GetArea()
	{
		return width * height;
	}
}
