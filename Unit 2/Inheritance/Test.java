class Test
{
	public static void main(String args[])
	{
		Circle circle;
		Shape shape;

		// Instantiate a circle with the following steps:
		//
		// 1. Allocates memory
		//
		// 2. Call to constructor of class Circle
		//
		// 	-> Call to constructor of Shape
		//
		// Variable 'circle' is now a reference to the new circle.
		circle = new Circle("My circle", 10);

		// Variable 'shape' is a reference to the same circle.
		// Due to polymorphism, this assignment is OK, because
		// the circle has every field accessible from a shape.
		shape = circle;

		// Print shape
		shape.Print();

		// Print area
		System.out.println("Shape area: " + shape.GetArea());
	}
}
