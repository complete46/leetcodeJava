package tree;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ShortestDistanceII {
	HashMap<String, List<Integer>> map;
    public ShortestDistanceII(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            } else {
                map.get(words[i]).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for (int i = 0, j = 0; i < list1.size() && j < list2.size();) {
            int i1 = list1.get(i);
            int i2 = list2.get(j);
            
            if (i1 > i2) {
                res = Math.min(res, i1 - i2);
                j++;
            } else {
                res = Math.min(res, i2 - i1);
                i++;
            }
        }
        
        return res;
    }
}
