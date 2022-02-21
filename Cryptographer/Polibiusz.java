package pl.edu.uj.lab3;


public class Polibiusz implements Algorithm {

	static final char[][] alphabet = { { 'A', 'B', 'C', 'D', 'E' },
			{ 'F', 'G', 'H', 'I', 'K' }, { 'L', 'M', 'N', 'O', 'P' },
			{ 'Q', 'R', 'S', 'T', 'U' }, { 'V', 'W', 'X', 'Y', 'Z' }, {'!','?', 0, 0, 0}};

	@Override
	public String crypt(String toCrypt) {
		String result = new String();
		toCrypt = toCrypt.toUpperCase();
		boolean flag;
		for (Character k : toCrypt.toCharArray()) {
			flag = false;
			for (int i = 0; i < alphabet.length && !flag; i++) {
				for (int j = 0; j < alphabet[0].length && !flag; j++) {
						if(k.equals('J')) {
							result += alphabet[5][0];
							result += alphabet[5][0];
							flag = true;
						}
						else if(k.equals(alphabet[1][3])){
							result += alphabet[5][1];
							result += alphabet[5][1];
							flag = true;
						}
						else if (k.equals(alphabet[i][j])) {
						result += i + 1;
						result += j + 1;
						flag = true;
					}
				}
			}
			if (!flag) {
				result += k;
				if (k != ' ')
					result += ' ';
				}
		}
		return result;
	}

	@Override
	public String decrypt(String s) {
		StringBuilder sb = new StringBuilder();
		s = s.toUpperCase();
		for (int i = 0; i < s.length(); i = i+2) {
			if(s.charAt(i)==' ')
			{
				sb.append(' ');
				i--;
			}
			else if(s.charAt(i)=='\n')
				sb.append('\n');
			else if(s.charAt(i)=='?')
				sb.append('I');
			else if(s.charAt(i)=='!')
				sb.append('J');
			else
			{
				int c = Character.getNumericValue(s.charAt(i));
				int d = Character.getNumericValue(s.charAt(i+1));
				System.out.print(c);
				System.out.print(d);
				sb.append(alphabet[c-1][d-1]);
			}
		}
		return sb.toString();
	}
}

