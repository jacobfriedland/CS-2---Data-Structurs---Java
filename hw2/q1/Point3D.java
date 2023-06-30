import java.util.*;
class Point3D extends Point
{
        private double x;
        private double y;
	private double z;	

        public void Read(Scanner scanner)
        {
                super.Read(scanner);
                System.out.print("Enter X: ");
                x = scanner.nextDouble();
                scanner.nextLine();
                System.out.print("Enter Y: ");
                y = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter Z: ");
                z = scanner.nextDouble();
        }

        public void Print()
        {
                super.Print();
                System.out.println("x cord: " + x);
                System.out.println("y cord: " + y);
		System.out.println("z cord: " + z);
        }

        public int GetNumCoordinates()
        {       
                System.out.println("Number of coordinates: " + 3);      
                return 3;
        }

        public double GetDistance(Point3D b)
        {
                double distance = Math.sqrt(Math.pow((x - b.x), 2) + Math.pow((y - b.y), 2) + Math.pow((z - b.z), 2));
                return distance;
        }

}
