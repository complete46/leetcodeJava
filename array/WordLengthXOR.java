
public class WordLengthXOR {
	public static int length(String[] words) {
		int res = 0;
		int mask = -1 << 26;
		for (int i = 0; i < words.length - 1; i++) {
			for (int j = i + 1; j < words.length; j++) {
				int a = toBit(words[i]) | mask;
				int b = toBit(words[j]);
				
				if ((a & b) == 0) {
					res = Math.max(res, words[i].length() * words[j].length());
				}
			}
		}
		return 0;
	}
	
	public static int toBit(String word) {
		int res = 0;
		
		for (char c = 'z'; c >= 'a'; c--) {
			if (word.indexOf(c) != -1) {
				res = ((res >> (int)(c - 'a')) | 1) << (int)(c - 'a');
			}
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		String a = "abc";
		String b = "def";
		
		int mask = (-1) << 26;
		System.out.println(Integer.toBinaryString(mask));
		
		System.out.println(Integer.toBinaryString(mask | toBit(a)));
		System.out.println(Integer.toBinaryString(mask | toBit(b)));
	}
}
