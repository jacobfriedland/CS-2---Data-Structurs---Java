import java.util.*;
class TestPoint3D
{
        public static void main(String args[])
        {
                Scanner scanner = new Scanner(System.in);
                Point3D a = new Point3D();
                Point3D b = new Point3D();
                a.Read(scanner);
                b.Read(scanner);
                a.Print();
                b.Print();
                a.GetNumCoordinates();
		double value = a.GetDistance(b);
                System.out.println("Distance: " + value);
	}     
}
