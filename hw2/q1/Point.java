import java.util.*;
abstract class Point
{
	private String name;
	
	public void Print()
	{
		System.out.println("Point " + name);
	}

	public void Read(Scanner scanner)
	{
		this.name = name;
		System.out.print("Enter name: ");
		name = scanner.next();	
	}

	public abstract int GetNumCoordinates();
}
