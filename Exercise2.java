import java.util.Scanner;
public class Exercise2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        try
        {
            System.out.print("Enter student name: ");
            String name = keyboard.nextLine();

            System.out.print("Enter student age: ");
            int age = keyboard.nextInt();

            // Check if age is outside valid range
            if (age < 16 || age > 100)
            {
                // Throw custom exception
                throw new InvalidAgeException("Age must be between 16 and 100.");
            }

            // If valid, display success message
            System.out.println("Student " + name + " with age " + age + " has been registered.");
        }
        catch (InvalidAgeException e)
        {
            // Catch and display error message
            System.out.println("Error: " + e.getMessage());
        }
    }
}
