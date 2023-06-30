import java.util.*;
class Test
{

	static int GetMinIndex(Shape v[], int left, int right)
	{

		int min_index = left;

		for (int i = left + 1; i<= right; i++)
                        if (v[i].compareTo(v[min_index]) == -1)
                                min_index = i;
			
		return min_index;
	}	

	static void Swap(Shape v[], int index1, int index2)
        {
                Shape temp = v[index1];
                v[index1] = v[index2];
                v[index2] = temp;
        }

	private static void Sort(Shape v[])
	{
		for (int i = 0; i < v.length - 1; i++)
		{
			int min_index = GetMinIndex(v, i, v.length - 1);

			Swap(v, min_index, i);
		}
	}
		
	public static void main(String args[])
	{		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of shapes: ");
		int number_shapes = scanner.nextInt();
		scanner.nextLine();
		Shape[] v = new Shape[number_shapes];
		
		for (int i = 0; i < number_shapes; i++)
		{
			System.out.print("Circle or Rectangle: ");
			String type = scanner.nextLine();

			if (type.equals("Circle"))
			{	
				System.out.print("Enter circle name: ");
				String cir_name = scanner.nextLine();
				System.out.print("Enter radius: ");
				double radius = scanner.nextDouble();
				scanner.nextLine();
				v[i] = new Circle(cir_name, radius);
			}
			else
			{

				System.out.print("Enter rectangle name: ");
				String rec_name = scanner.nextLine();
				System.out.print("Enter height: ");
                                double height = scanner.nextDouble();
				scanner.nextLine();
				System.out.print("Enter width: ");
                                double width = scanner.nextDouble();
				scanner.nextLine();
				v[i] = new Rectangle(rec_name, width, height);
			} 					
		}
		
		Sort(v);

		for (int i = 0; i < v.length; i++)
		{
			v[i].Print();
		}
	
	}
}
