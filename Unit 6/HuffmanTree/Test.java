class Test
{
	public static void main(String args[])
	{
		HuffmanTree tree = new HuffmanTree();

		String text = "mississippi";
		tree.CreateLeafNodes(text);
		tree.BuildTree();

		tree.Encode(text);
	}
}
