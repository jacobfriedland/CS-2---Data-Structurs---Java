class Test
{
	public static void main(String args[])
	{
		// Create persons
		Person p1 = new Person("John", 20);
		Person p2 = new Person("Mary", 25);
		Person p3 = new Person("Adam", 21);
		Person p4 = new Person("Zack", 22);

		// Create tree
		Tree tree = new Tree();

		// Add persons
		tree.Insert(p1.GetName(), p1);
		tree.Insert(p2.GetName(), p2);
		tree.Insert(p3.GetName(), p3);
		tree.Insert(p4.GetName(), p4);

		// Print tree
		tree.Print();

		// Print minimum value
		System.out.println("First person: " + tree.GetMin());

		// Print successors
		System.out.println("Successor of Mary: " + tree.GetSuccessor("Mary"));
		System.out.println("Successor of Zack: " + tree.GetSuccessor("Zack"));
	}
}
