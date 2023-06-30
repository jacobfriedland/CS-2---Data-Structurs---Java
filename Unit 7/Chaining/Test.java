class Test
{
	public static void main(String args[])
	{
		// Create persons
		Person p1 = new Person("John", 20);
		Person p2 = new Person("Mary", 25);
		Person p3 = new Person("Adam", 21);
		Person p4 = new Person("Zack", 22);
		Person p5 = new Person("Susan", 30);

		// Insert them into a hash table
		HashTable hash_table = new HashTable();
		hash_table.Insert(p1.GetName(), p1);
		hash_table.Insert(p2.GetName(), p2);
		hash_table.Insert(p3.GetName(), p3);
		hash_table.Insert(p4.GetName(), p4);
		hash_table.Insert(p5.GetName(), p5);

		// Queries
		System.out.println(hash_table.Search("Mary"));
		System.out.println(hash_table.Search("Zack"));
	}
}
