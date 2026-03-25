// Custom exception for invalid grade
public class InvalidGradeException extends Exception
{
    public InvalidGradeException(String message)
    {
        super(message);
    }
}