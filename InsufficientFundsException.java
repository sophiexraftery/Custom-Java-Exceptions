// Custom exception class
public class InsufficientFundsException extends Exception
{
    // Constructor with message
    public InsufficientFundsException(String message)
    {
        super(message); // Store message in parent Exception class
    }
}