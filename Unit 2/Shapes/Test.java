class Test
{
	public static void main(String args[])
	{
		// Instantiate rectangle
		Rectangle rectangle = new Rectangle("my-rectangle");

		// Set dimensions
		rectangle.SetDimensions(2.2, 3.3);

		// Get area
		double area = rectangle.GetArea();
		System.out.println("Rectangle area: " + area);

		// Instantiate triangle
		Triangle triangle = new Triangle("my-triangle");

		// Set dimensions
		triangle.SetDimensions(3, 4);

		// Print area
		area = triangle.GetArea();
		System.out.println("Triangle area: " + area);
	}
}
