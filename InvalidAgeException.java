// Custom exception class
public class InvalidAgeException extends Exception
{
    // Constructor that takes a message
    public InvalidAgeException(String message)
    {
        super(message); // Store message in Exception class
    }
}