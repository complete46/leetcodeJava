import java.util.HashMap;

public class LengthOfLongestSubstringTwoDistinct {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int maxLen = 0;
		int maxStart = 0;
		int start = 0;

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				if (map.size() < 2) {
					map.put(c, 1);
				} else {
					while (true) {
						char t = s.charAt(start++);
						if (map.get(t) == 1) {
							map.remove(t);
							break;
						} else {
							map.put(t, map.get(t) - 1);
						}
					}
				}
				map.put(c, 1);
			}

			if (i - start + 1 > maxLen) {
				maxLen = i - start + 1;
				maxStart = i;
			}
		}

		return maxLen;
	}
}
