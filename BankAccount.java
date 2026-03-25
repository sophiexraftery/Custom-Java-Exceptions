// Bank account class
public class BankAccount
{
    private double balance;

    public BankAccount(double balance)
    {
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount)
    {
        balance = balance + amount;
    }

    // Withdraw method
    public void withdraw(double amount) throws InsufficientFundsException
    {
        if (amount > balance)
        {
            throw new InsufficientFundsException("Not enough funds to complete withdrawal.");
        }

        balance = balance - amount;
    }

    public double getBalance()
    {
        return balance;
    }
}