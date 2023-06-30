class Test
{
	public static void main(String args[])
	{
		BinarySearchTree tree1 = new BinarySearchTree();
		BinarySearchTree tree2 = new BinarySearchTree();	
		BinarySearchTree tree3 = new BinarySearchTree();
		
		tree1.Insert(Integer.valueOf(5), null);	
		tree1.Insert(Integer.valueOf(2), null);
		tree1.Insert(Integer.valueOf(8), null);
		tree1.Insert(Integer.valueOf(1), null);
		tree1.Insert(Integer.valueOf(3), null);
		tree1.Insert(Integer.valueOf(7), null);
		tree1.Insert(Integer.valueOf(10), null);

		tree2.Insert(Integer.valueOf(8), null);	
		tree2.Insert(Integer.valueOf(7), null);
		tree2.Insert(Integer.valueOf(10), null);
		tree2.Insert(Integer.valueOf(5), null);
		tree2.Insert(Integer.valueOf(2), null);
		tree2.Insert(Integer.valueOf(1), null);
		tree2.Insert(Integer.valueOf(3), null);

		tree3.Insert(Integer.valueOf(1), null);	
		tree3.Insert(Integer.valueOf(3), null);
		tree3.Insert(Integer.valueOf(2), null);
		tree3.Insert(Integer.valueOf(5), null);
		tree3.Insert(Integer.valueOf(7), null);
		tree3.Insert(Integer.valueOf(8), null);
		tree3.Insert(Integer.valueOf(10), null);

		System.out.println(tree1.GetHeight());	
		System.out.println(tree2.GetHeight());
		System.out.println(tree3.GetHeight());
	}

}
