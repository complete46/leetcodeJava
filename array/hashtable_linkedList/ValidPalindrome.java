package hashtable_linkedList;

public class ValidPalindrome {
	public static boolean isPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				sb.append(s.charAt(i));
			}

			if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
				sb.append((char)(s.charAt(i) + 32));
			}

			if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
				sb.append(s.charAt(i));
			}
		}
		System.out.println(sb);
		int i = 0;
		int j = sb.length() - 1;
		while (i++ < j--) {
			System.out.println(sb.charAt(i));
			System.out.println(sb.charAt(j));

			if (sb.charAt(i) != sb.charAt(j)) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("aA"));
	}
}
