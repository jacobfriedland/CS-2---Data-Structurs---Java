import java.util.Random;
class Test
{
	public static void main(String args[])
	{		
		String algorithm = args[0];
		int size = Integer.parseInt(args[1]);
		Random rand = new Random();
		int [] array = new int[size];
		for (int i = 0; i < array.length; i++)
		{
			array[i] = rand.nextInt();
		}
		
		if (algorithm.equals("selection"))
			SelectionSort.Sort(array);
		else
			MergeSort.Sort(array);  		
	}
}
