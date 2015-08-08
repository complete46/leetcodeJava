package hashtable;

public class LengthOfLongestSubstring {
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		boolean[] map = new boolean[256];
		int cur = 0;

		int i = 0;
		int j = 0;

		while (i < s.length()) {
			while (j < s.length() && !map[s.charAt(j)]) {
				cur++;
				map[s.charAt(j)] = true;
				j++;
			}

			max = Math.max(cur, max);
			map[s.charAt(i)] = false;
			i++;
			cur--;
		}

		return max;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("cdd"));
	}
}
