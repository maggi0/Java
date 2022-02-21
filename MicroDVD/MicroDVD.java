import java.io.*;
import java.util.regex.*;

public class MicroDVD {
	
	public static void delay(String in, String out, int delay, int fps) throws IOException, FirstNumberHigherException, InvalidCharacterException{
		FileInputStream istream = new FileInputStream(in);
		FileOutputStream ostream = new FileOutputStream(out);
		BufferedReader br_i = new BufferedReader(new InputStreamReader(istream));
		BufferedWriter br_o = new BufferedWriter(new OutputStreamWriter(ostream));
		
		String strLine;
		int i = 0;
		while ((strLine = br_i.readLine()) != null){
			i++;
			String delayed = delayer(strLine, delay, fps, i);
			br_o.write(delayed);
			br_o.newLine();
		}
		
		br_i.close();
		br_o.close();
	}


	public static String delayer(String in, int delay, int fps, int i) throws FirstNumberHigherException, InvalidCharacterException {
		String[] line = in.split("}");
		if ((Pattern.matches("\\{[0-9]*", line[0])) && (Pattern.matches("\\{[0-9]*", line[1]))) {
			line[0] = line[0].substring(1);
			line[1] = line[1].substring(1);
			Integer begin = Integer.parseInt(line[0]);
			Integer end = Integer.parseInt(line[1]);
			if (begin > end) {
				String message = "{" + begin.toString() + "}{" + end.toString() + "}" + line[2];
				throw new FirstNumberHigherException(message, i);
			}
			begin += delay * fps / 1000;
			end += delay * fps / 1000;
			return "{" + begin.toString() + "}{" + end.toString() + "}" + line[2];
		} 
		else {
			String message = line[0] + line[1] + line[2];
			throw new InvalidCharacterException(message, i);
		}
	}

}
