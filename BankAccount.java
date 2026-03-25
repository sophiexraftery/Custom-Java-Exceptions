// BankAccount class
public class BankAccount
{
    private double balance;

    // Constructor to set initial balance
    public BankAccount(double balance)
    {
        this.balance = balance;
    }

    // Withdraw method
    public void withdraw(double amount) throws InsufficientFundsException
    {
        // Check if withdrawal amount is greater than balance
        if (amount > balance)
        {
            // Throw custom exception
            throw new InsufficientFundsException("Withdrawal amount exceeds available balance.");
        }

        // Deduct amount if valid
        balance = balance - amount;
    }

    // Getter to return balance
    public double getBalance()
    {
        return balance;
    }
}