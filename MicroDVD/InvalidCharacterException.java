package pl.edu.uj.lab4;

public class InvalidCharacterException extends Exception{

	InvalidCharacterException(String message, int i)
	{
		System.out.println("Wyjatek wystapil w " + i + " linijce tekstu");
		System.out.println("Tresc linijki: " + message);
	}
}
