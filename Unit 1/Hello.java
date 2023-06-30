import java.util.*;

class Hello
{
	public static void main(String[] args)
	{
		// Create scanner
		Scanner scanner = new Scanner(System.in);

		// Read name
		System.out.print("Enter name: ");
		String name = scanner.nextLine();

		// Print message
		System.out.println("Hello, " + name);
	}
}

