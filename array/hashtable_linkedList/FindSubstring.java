package hashtable_linkedList;

import java.util.*;

public class FindSubstring {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		HashMap<String, Integer> map = new HashMap<String, Integer>();

		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i])) {
				map.put(words[i], 0);
			}
			map.put(words[i], map.get(words[i]) + 1);
		}

		int len = words[0].length();
		int totalLen = words.length * len;

		for (int i = 0; i + totalLen <= s.length(); i++) {
			HashMap<String, Integer> map2 = new HashMap<String, Integer>();
			int count = 0;
			for (int j = i; j + len <= s.length(); j += len) {
				String str = s.substring(j, j + len);

				if (map.containsKey(str)) {
					if (!map2.containsKey(str)) {
						map2.put(str, 0);
					}

					if (map2.put(str, map2.get(str) + 1) >= map.get(str)) {
						break;
					} else {
						count++;
					}
				} else {
					break;
				}
			}
			if (count == words.length) {
				res.add(i);
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String s = "wordgoodgoodgoodbestword";
		String[] words = {"word","good","best","good"};
		List<Integer> res = findSubstring(s, words);
		for (int i : res) {
			System.out.println(i);
		}
	}
}
