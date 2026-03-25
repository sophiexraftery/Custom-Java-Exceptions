import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

public class Exercise4
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        FileWriter fw = null;

        try
        {
            System.out.print("Enter number of students: ");
            int numStudents = keyboard.nextInt();

            int[] scores = new int[numStudents];

            for (int i = 0; i < numStudents; i++)
            {
                System.out.print("Enter score for student " + (i + 1) + ": ");
                int score = keyboard.nextInt();

                if (score < 0 || score > 100)
                {
                    throw new InvalidScoreException("Score must be between 0 and 100.");
                }

                scores[i] = score;
            }

            // Write to file
            fw = new FileWriter("scores.txt");

            for (int i = 0; i < numStudents; i++)
            {
                fw.write(scores[i] + "\n");
            }

            System.out.println("Scores successfully saved to scores.txt");
        }
        catch (InputMismatchException e)
        {
            System.out.println("Error: Invalid input. Please enter an integer.");
        }
        catch (InvalidScoreException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println("Error writing to file.");
        }
        finally
        {
            try
            {
                if (keyboard != null)
                {
                    keyboard.close();
                    System.out.println("Scanner closed.");
                }

                if (fw != null)
                {
                    fw.close();
                }
            }
            catch (IOException e)
            {
                System.out.println("Error closing writer.");
            }
        }
    }
}
