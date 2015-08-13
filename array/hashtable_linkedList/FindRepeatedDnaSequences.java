package hashtable_linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
public class FindRepeatedDnaSequences {
	public static List<String> findRepeatedDnaSequences(String s) {
List<String> res = new ArrayList<String>();
        
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        
        for (int i = 0; i + 10 <= s.length(); i++) {
            int key = stoi(s.substring(i, i + 10));
            if (!map.containsKey(key)) {
                map.put(key, true);
            } else {
                if (map.get(key) == true) {
                    res.add(s.substring(i, i + 10));
                    map.put(key, false);
                }
            }
        }
        
        return res;
	}
	
	public static int stoi(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'A':
                    res |= 0;
                    res <<= 2;
                    break;
                case 'T':
                    res |= 1;
                    res <<= 2;
                    break;
                case 'C':
                    res |= 2;
                    res <<= 2;
                    break;
                case 'G':
                    res |= 3;
                    res <<= 2;
                    break;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		String s ="AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> res = findRepeatedDnaSequences(s);
		for (String str : res) {
			System.out.println(str);
		}
		System.out.println(0 | 2);
	}
}
