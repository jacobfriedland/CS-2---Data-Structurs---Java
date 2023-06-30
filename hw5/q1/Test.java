class Test
{
	public static void main(String args[])
	{
		Vector vector = new Vector();
		
		// Add items
		vector.Add(Integer.valueOf(0));	
		vector.Add(Integer.valueOf(1));
		vector.Add(Integer.valueOf(2));
		vector.Add(Integer.valueOf(3));
		vector.Add(Integer.valueOf(4));

		// Remove items
		vector.Remove(0);
		vector.Remove(0);
		vector.Remove(0);
		vector.Remove(0);	

		vector.Print();	
	}
}
