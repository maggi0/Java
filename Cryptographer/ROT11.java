package pl.edu.uj.lab3;

public class ROT11 implements Algorithm{
	
	static final int rot = 11;
	static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	@Override
	public String crypt(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			for(int j = 0; j < alphabet.length(); j++)
			{
				if(c == alphabet.charAt(j))
				{
					if(j <= (alphabet.length() - rot))
						c = alphabet.charAt(j += rot);
					else
					{
						int d = (alphabet.length() - rot);
						c = alphabet.charAt(j - d);
					}
				}
			}
		    sb.append(c);
		}
		return sb.toString();
	}	
	
	@Override
	public String decrypt(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			for(int j = 0; j < alphabet.length(); j++)
			{
				if(c == alphabet.charAt(j))
				{
					if(j >= rot)
						c = alphabet.charAt(j -= rot);
					else
					{
						int d = (alphabet.length() - rot);
						System.out.println(d);
						c = alphabet.charAt(j += d);
					}
				}
			}
		    sb.append(c);
		}
		return sb.toString();
	}
}
