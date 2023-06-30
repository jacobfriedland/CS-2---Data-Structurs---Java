class Test
{
	static int GetStringLength(String s)
	{
		return s.length();
	}

	static int Divide(int a, int b)
	{
		return a / b;
	}

	static void CheckPositive(int x)
	{
		if (x < 0)
			throw new IllegalArgumentException("Not a positive number");
	}

	public static void main(String args[])
	{
		// Valid call to 'GetStringLength'
		int length = GetStringLength("abc");
		System.out.println("String length: " + length);

		// Invalid call with unhandled exception
		// GetStringLength(null);

		// Invalid call with handled exception
		try
		{
			GetStringLength(null);
		}
		catch (NullPointerException e)
		{
			System.out.println("Error: String length of null");
		}

		// Valid call to 'Divide'
		int result = Divide(10, 2);
		System.out.println("Quotient: " + result);

		// Invalid call with unhandled exception
		// Divide(10, 0);

		// Invalid call with handled exception
		try
		{
			Divide(10, 0);
		}
		catch (ArithmeticException e)
		{
			System.out.println("Error: Division by zero");
		}

		// Valid call to 'CheckPositive'
		CheckPositive(10);

		// Invalid call with unhandled exception
		CheckPositive(-1);
	}
}
