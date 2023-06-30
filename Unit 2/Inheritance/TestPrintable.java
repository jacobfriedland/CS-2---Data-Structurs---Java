class TestPrintable
{
	static void PrintWithLine(Printable printable)
	{
		printable.Print();
		System.out.println("----------------------");
	}

	public static void main(String args[])
	{
		Circle circle = new Circle("my-circle", 10);
		Person person = new Person("John", 20);

		PrintWithLine(circle);
		PrintWithLine(person);
	}
}
