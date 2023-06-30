import java.util.*;
class TestPoint2D
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		Point2D a = new Point2D();
		Point2D b = new Point2D();
		a.Read(scanner);
		b.Read(scanner);
		a.Print();
		b.Print();
		a.GetNumCoordinates();
		double value = a.GetDistance(b);
		System.out.println("Distance: " + value);
	}
}
