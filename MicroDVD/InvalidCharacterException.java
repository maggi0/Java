public class InvalidCharacterException extends Exception{

	InvalidCharacterException(String message, int i)
	{
		System.out.println("Exception in " + i + " line of the text");
		System.out.println("Line is: " + message);
	}
}
