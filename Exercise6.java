//Exercise 6, InvalidGradeException, StudentNotFoundException
import java.util.Scanner;
import java.io.*;
import java.util.InputMismatchException;

public class Exercise6
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        boolean running = true;

        while (running)
        {
            System.out.println("\n--- Student Grading System ---");
            System.out.println("1. Look up student grade");
            System.out.println("2. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;

            try
            {
                choice = keyboard.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Error: Invalid input.");
                keyboard.next(); // clear invalid input
            }

            keyboard.nextLine(); // consume leftover newline

            switch (choice)
            {
                case 1: // Look up student grade
                    System.out.print("Enter student name: ");
                    String searchName = keyboard.nextLine();

                    Scanner file = null;

                    try
                    {
                        file = new Scanner(new File("students.txt"));
                        boolean found = false;

                        while (file.hasNextLine())
                        {
                            String line = file.nextLine();
                            String[] parts = line.split(",\\s*");

                            String name = parts[0];
                            int grade = Integer.parseInt(parts[1]);

                            if (name.equalsIgnoreCase(searchName))
                            {
                                found = true;

                                if (grade < 0 || grade > 100)
                                {
                                    throw new InvalidGradeException("Grade for student '" + name + "' is invalid.");
                                }

                                System.out.println(name + "'s grade is: " + grade);
                                break;
                            }
                        }

                        if (!found)
                        {
                            throw new StudentNotFoundException("Student '" + searchName + "' not found.");
                        }
                    }
                    catch (FileNotFoundException e)
                    {
                        System.out.println("Error: File students.txt not found.");
                    }
                    catch (StudentNotFoundException | InvalidGradeException e)
                    {
                        System.out.println("Error: " + e.getMessage());
                    }
                    catch (NumberFormatException e)
                    {
                        System.out.println("Error: Invalid grade format in file.");
                    }
                    finally
                    {
                        if (file != null)
                        {
                            file.close();
                            System.out.println("File scanner closed.");
                        }
                    }
                    break;

                case 2: // Exit
                    System.out.println("Exiting program.");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    break;
            }
        }

        if (keyboard != null)
        {
            keyboard.close();
            System.out.println("Input scanner closed.");
        }
    }
}
