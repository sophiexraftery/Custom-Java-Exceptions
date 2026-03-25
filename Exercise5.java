import java.util.Scanner;
import java.util.InputMismatchException;
import java.io.*;

public class Exercise5
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        FileWriter fw = null;

        try
        {
            fw = new FileWriter("transactions.txt", true); // Append mode
            BankAccount account = new BankAccount(200.0);

            boolean running = true;

            while (running)
            {
                // Display menu
                System.out.println("\n====== Bank Account Menu ======");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Enter your choice: ");

                int choice = keyboard.nextInt();

                switch (choice)
                {
                    case 1: // Check Balance
                        System.out.printf("Current balance: %.2f\n", account.getBalance());
                        break;

                    case 2: // Deposit
                        System.out.print("Enter amount to deposit: ");
                        try
                        {
                            double depositAmount = keyboard.nextDouble();
                            account.deposit(depositAmount);
                            System.out.printf("Deposit successful. New balance: %.2f\n", account.getBalance());
                            fw.write("Deposit: " + depositAmount + ", New balance: " + account.getBalance() + "\n");
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Error: Invalid input.");
                            fw.write("Invalid deposit input entered.\n");
                            keyboard.next(); // clear invalid input
                        }
                        break;

                    case 3: // Withdraw
                        System.out.print("Enter amount to withdraw: ");
                        try
                        {
                            double withdrawAmount = keyboard.nextDouble();
                            try
                            {
                                account.withdraw(withdrawAmount);
                                System.out.printf("Withdrawal successful. New balance: %.2f\n", account.getBalance());
                                fw.write("Withdrawal: " + withdrawAmount + ", New balance: " + account.getBalance() + "\n");
                            }
                            catch (InsufficientFundsException e)
                            {
                                System.out.println("Error: " + e.getMessage());
                                fw.write("Failed withdrawal: " + withdrawAmount + " - " + e.getMessage() + "\n");
                            }
                        }
                        catch (InputMismatchException e)
                        {
                            System.out.println("Error: Invalid input.");
                            fw.write("Invalid withdrawal input entered.\n");
                            keyboard.next(); // clear invalid input
                        }
                        break;

                    case 4: // Exit
                        System.out.println("Exiting... Goodbye!");
                        running = false;
                        break;

                    default:
                        System.out.println("Invalid choice. Please select 1-4.");
                        fw.write("Invalid menu choice attempted.\n");
                        break;
                }
            }
        }
        catch (IOException e)
        {
            System.out.println("Error opening file.");
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
                System.out.println("Error closing log file.");
            }
        }
    }
}