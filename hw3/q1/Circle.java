class Circle extends Shape
{
	double radius;
	
	public Circle(String name, double radius)
	{
		super(name);
		this.radius = radius;
	}
	
	public void Print()
	{
		System.out.println("Circle has radius " + radius);
	}

	public double GetArea()
	{
		return Math.PI * radius * radius;
	}
}
