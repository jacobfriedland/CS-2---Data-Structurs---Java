import java.util.*;
class Point2D extends Point
{
	private double x;
	private double y;

	public void Read(Scanner scanner)
	{
		super.Read(scanner);
		System.out.print("Enter X: ");
		x = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter Y: ");
		y = scanner.nextDouble();
	}	

	public void Print()
	{
		super.Print();
		System.out.println("x cord: " + x);
		System.out.println("y cord: " + y);
	}

	public int GetNumCoordinates()
	{
		System.out.println("Number of coordinates: " + 2);
		return 2;		
	}

	public double GetDistance(Point2D b)
	{
		double distance = Math.sqrt(Math.pow((x - b.x), 2) + Math.pow((y - b.y), 2));
		return distance;
	} 
	
	
}
