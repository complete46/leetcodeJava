package hashtable_linkedList;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        List<String> res = new ArrayList<String>();
        for (int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String newStr = new String(s);
            
            if (!map.containsKey(newStr)) {
                map.put(newStr, new ArrayList<String>());
            }
            map.get(newStr).add(strs[i]);
        }
        
        for (List<String> list : map.values()) {
            if (list.size() > 1) {
                for (String str : list) {
                    res.add(str);
                }
            }
        }
        
        return res;
    }
}
