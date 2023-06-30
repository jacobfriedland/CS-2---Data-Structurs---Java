import java.util.Scanner;
class Test
{
	public static void main(String args[])
	{
		
		int arr[] = {1, 2, 3, 4, 5, 6};		
		Scanner scanner = new Scanner(System.in);

		while (true)
		{
                	System.out.print("Enter integer value representing index in array: ");
                	int index = scanner.nextInt();
			try
                	{
				System.out.println(arr[index]);
                	}
                	catch (ArrayIndexOutOfBoundsException e)
                	{
                        	System.out.println("Error: Index is out of bounds");
				return;
                	}
		}					
	}	
}
