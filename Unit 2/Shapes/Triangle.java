class Triangle
{
	double base;
	double height;
	String name;

	public Triangle(String name)
	{
		this.name = name;
	}

	public void SetDimensions(double base, double height)
	{
		this.base = base;
		this.height = height;
	}

	public double GetArea()
	{
		return base * height / 2;
	}
}
