import java.util.Scanner;

public class Exercise3
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        BankAccount account = new BankAccount(100.0);

        try
        {
            System.out.println("Your current balance is: " + account.getBalance());

            System.out.print("Enter amount to withdraw: ");
            double amount = keyboard.nextDouble();

            // Attempt withdrawal
            account.withdraw(amount);

            // If successful
            System.out.println("Withdrawal successful. New balance: " + account.getBalance());
        }
        catch (InsufficientFundsException e)
        {
            // Handle exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}