// Custom exception class
//java already has a custom built-in exception class
public class NegativeNumberException extends Exception
{
    // Constructor that accepts a message
    public NegativeNumberException(String message)
    {
        super(message); // Pass message to Exception class
    }
}