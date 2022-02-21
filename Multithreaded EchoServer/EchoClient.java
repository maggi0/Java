import java.io.*;
import java.net.*;
import java.util.Arrays;

public class EchoClient {

    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for "
                    + "the connection to: localhost.");
            System.exit(1);
        }

        BufferedReader stdIn = new BufferedReader(new InputStreamReader(
                System.in));
        String userInput;

        System.out.println(
                "Input range (eg. 1 100): ");
        while ((userInput = stdIn.readLine()) != null) {
            out.println(userInput);
            System.out.println("Primes in the range: " + primes(in.readLine()));
        }

        out.close();

        in.close();

        stdIn.close();

        echoSocket.close();
    }
    
    public static String primes(String line)
    {
    	String range[] = line.split(" ");
    	int primes[] = new int[0];
    	if(range.length != 2 || Integer.parseInt(range[0]) > Integer.parseInt(range[1]))
    	{
    		System.out.println("Wrong arguments");
    	}
    	else
    	{
    		int first = Integer.parseInt(range[0]);
    		int second = Integer.parseInt(range[1]);
    		for(int i = first; i <= second; i++)
    		{
    			if(isPrime(i) == true)
    			{
    				primes = Arrays.copyOf(primes, primes.length + 1);
    				primes[primes.length - 1] = i;
    			}
    		}
    	}
    	String result = "";
    	for(int number : primes)
    	{
    		result += number + " ";
    	}
    	return result;
    }
    
    public static boolean isPrime(int n) {  
        if (n <= 1) {  
            return false;  
        }  
        for (int i = 2; i <= Math.sqrt(n); i++) {  
            if (n % i == 0) {  
                return false;  
            }  
        }  
        return true;  
    }
}