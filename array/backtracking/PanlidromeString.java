package backtracking;
import java.util.List;
import java.util.ArrayList;

public class PanlidromeString {
	public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        dfs(res, new ArrayList<String>(), 0, s);
        
        return res;
    }
    
    public static void dfs(List<List<String>> res, List<String> item, int start, String s) {
        if (start == s.length()) {
            res.add(new ArrayList<String>(item));
            return;
        }
        
        for (int i = 1; start + i <= s.length(); i++) {
            if (isPal(s.substring(start, start + i))) {
                item.add(s.substring(start, start + i));
                dfs(res, item, start + i, s);
                item.remove(item.size() - 1);
            }
        }
    }
    
    public static boolean isPal(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
    	String s = "aab";
    	
    	List<List<String>> res = partition(s);
    	for (List<String> item : res) {
    		for (String i : item) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	} 
    }
}
