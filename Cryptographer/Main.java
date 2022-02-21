import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		
		FileInputStream istream = new FileInputStream(args[0]);
		FileInputStream ostream = new FileInputStream(args[1]);
		BufferedReader br_i = new BufferedReader(new InputStreamReader(istream));
		BufferedReader br_o = new BufferedReader(new InputStreamReader(ostream));
		
		Algorithm ROT11 = new ROT11();
		Algorithm Polibiusz = new Polibiusz();
		
		if(args[2].equals("crypt"))
		{
			if(args[3].equals("rot"))
				Cryptographer.cryptfile(args[0], args[1], ROT11);
			else if(args[3].equals("Polibiusz"))
				Cryptographer.cryptfile(args[0], args[1], Polibiusz);
			else
			{
				System.out.println("Wrong algorithm argument!");
				System.exit(0);
			}
		}
		else if(args[2].equals("decrypt"))
		{
			if(args[3].equals("rot"))
				Cryptographer.decryptfile(args[0], args[1], ROT11);
			else if(args[3].equals("Polibiusz"))
				Cryptographer.decryptfile(args[0], args[1], Polibiusz);
			else
			{
				System.out.println("Wrong algorithm argument!");
				System.exit(0);
			}
		}
		else
		{
			System.out.println("Wrong crypting argument!");
			System.exit(0);
		}
		
		
		String strLine;
		
		System.out.println("Input file: ");
		while ((strLine = br_i.readLine()) != null){
			System.out.println (strLine);
		}
		
		System.out.println("Output file: ");
		while ((strLine = br_o.readLine()) != null){
			System.out.println (strLine);
		}
		
		br_i.close();
		br_o.close();
	}

}
