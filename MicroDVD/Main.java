package pl.edu.uj.lab4;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		
		try {
			MicroDVD.delay(args[0], args[1], Integer.parseInt(args[2]), Integer.parseInt(args[3]));
		} 
		catch (IndexOutOfBoundsException e) {
			System.out.println("Niepoprawna ilo�� argument�w programu");
		} 
		catch (NumberFormatException e) {
			System.out.println("Niepoprawny format argument�w");
		} 
		catch (IOException e) {
			System.out.println("Niepoprawne wej�cie/wyj�cie");
		} 
		catch (FirstNumberHigherException e) {
			System.out.println("Niepoprawna sekwencja klatek.");
		}
		catch (InvalidCharacterException e) {
			System.out.println("Niepoprawne znaki");
		}
		catch(Exception e)
		{
			System.out.println("Nieznany typ wyjatku");
		}
	}
}
