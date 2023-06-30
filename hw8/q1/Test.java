class Test
{
	public static void main(String args[])
	{
		HuffmanTree tree = new HuffmanTree();
		
		if (args.length > 1)
			throw new RuntimeException("More than one argument passed in command line");

		String original_text = args[0];

		System.out.println("Original text: " + original_text);
		tree.CreateLeafNodes(original_text);
		tree.BuildTree();
		String encoded_text = tree.Encode(original_text);
		System.out.println("Encoded text: " + encoded_text);
		int compression_ratio = ((encoded_text.length()* 100) / (original_text.length() * 8));
		System.out.println("Compression ratio: " + compression_ratio + "%");
		String decoded_text = tree.Decode(encoded_text);
		System.out.println("Decoded text: " + decoded_text);
	}
}
