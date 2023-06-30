class Person implements Printable
{
	String name;
	int age;

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;
	}

	public void Print()
	{
		System.out.println(name + " is " + age + " years old.");
	}
}
