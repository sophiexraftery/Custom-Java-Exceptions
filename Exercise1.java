//Exercise 1, NegativeNumberException
import java.util.Scanner;

public class Exercise1
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        try
        {
            System.out.print("Enter a number: ");
            int number = keyboard.nextInt();

            // Check if number is negative
            if (number < 0)
            {
                // Throw custom exception
                throw new NegativeNumberException("Negative numbers are not allowed.");
            }

            // If number is positive, display it
            System.out.println("You entered: " + number);
        }
        catch (NegativeNumberException e)
        {
            // Catch exception and print error message
            //getMessage is a built in method to Javas Exception class, similar like toString()
            System.out.println("Error: " + e.getMessage());
        }
    }
}
