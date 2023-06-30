import java.util.*;
class Palindrome
{
    public static boolean IsPalindrome(String str)
        {
                if(str.length() == 0 || str.length() == 1)

                         return true;
                
                if(str.charAt(0) == str.charAt(str.length() - 1))

                        return IsPalindrome(str.substring(1, str.length() - 1));

                else 
                         return false;
        }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter string: ");
        String string = scanner.nextLine();

        if(IsPalindrome(string) == true)

            System.out.println("The string is a palindrome");
        
        else

            System.out.println("The string is not a palindrome");
    }
}
