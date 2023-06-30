import java.util.Random;
class Test
{
	public static void main(String args[])
	{	
		String insert_method = args[0];
		int insertions = Integer.parseInt(args[1]);
		Random rand = new Random();
		BinarySearchTree tree = new BinarySearchTree();
		
		if (args.length != 2)
			throw new IllegalArgumentException("Exactly 2 arguments required");

		else if (!insert_method.equals("sorted") && !insert_method.equals("random"))
				System.out.println("Did not choose 'sorted' or 'random' options");

		else
			try
			{
				if (insert_method.equals("sorted"))
					for (int i=0; i < insertions; i++)
						tree.Insert(i, null);
				else
					for (int i=0; i < insertions; i++)
						tree.Insert(rand.nextInt(), null);
			}
			catch(RuntimeException e)
			{
			}
	}
}
