import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		try {
			MicroDVD.delay(args[0], // input file 
					args[1], // output file
					Integer.parseInt(args[2]), // miliseconds 
					Integer.parseInt(args[3])); // framerate
		} 
		catch (IndexOutOfBoundsException e) {
			System.out.println("Invalid arguments number");
		} 
		catch (NumberFormatException e) {
			System.out.println("Invalid arguments format");
		} 
		catch (IOException e) {
			System.out.println("Invalid Input/Output");
		} 
		catch (FirstNumberHigherException e) {
			System.out.println("Invalid frame sequence");
		}
		catch (InvalidCharacterException e) {
			System.out.println("Invalid characters");
		}
		catch(Exception e)
		{
			System.out.println("Unknown exception");
		}
	}
}
