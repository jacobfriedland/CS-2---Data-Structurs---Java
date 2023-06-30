class RecursiveFactorial
{
	static int Factorial(int n)
	{
		// Base case
		if (n < 2)
			return n;

		// Recursive call
		int previous_factorial = Factorial(n - 1);

		// Result
		return n * previous_factorial;
	}

	public static void main(String args[])
	{
		System.out.println(Factorial(5));
	}
}
