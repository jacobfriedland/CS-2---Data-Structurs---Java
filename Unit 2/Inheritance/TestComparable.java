class TestComparable
{
	public static void main(String args[])
	{
		Circle circle = new Circle("my-circle", 1);
		Rectangle rectangle = new Rectangle("my-rect", 2, 5);
		Rectangle other_rectangle = new Rectangle("other-rect", 2.5, 4);

		System.out.println(circle.compareTo(rectangle));
		System.out.println(rectangle.compareTo(circle));
		System.out.println(rectangle.compareTo(other_rectangle));
	}
}
