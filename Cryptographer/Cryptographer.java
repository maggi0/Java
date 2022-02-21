import java.io.*;

public class Cryptographer{
	
	public static void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) throws IOException {
		FileInputStream istream = new FileInputStream(path_to_file_in);
		FileOutputStream ostream = new FileOutputStream(path_to_file_out);
		BufferedReader br_i = new BufferedReader(new InputStreamReader(istream));
		BufferedWriter br_o = new BufferedWriter(new OutputStreamWriter(ostream));
		
		String strLine;
		
		while ((strLine = br_i.readLine()) != null){
			String crypted = algorithm.crypt(strLine);
			br_o.write(crypted);
			br_o.newLine();
		}
		
		br_i.close();
		br_o.close();
	}
	
	public static void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) throws IOException{
		FileInputStream istream = new FileInputStream(path_to_file_in);
		FileOutputStream ostream = new FileOutputStream(path_to_file_out);
		BufferedReader br_i = new BufferedReader(new InputStreamReader(istream));
		BufferedWriter br_o = new BufferedWriter(new OutputStreamWriter(ostream));
		
		String strLine;
		
		while ((strLine = br_i.readLine()) != null){
			String decrypted = algorithm.decrypt(strLine);
			br_o.write(decrypted);
			br_o.newLine();
		}
		
		br_i.close();
		br_o.close();
	}

}
