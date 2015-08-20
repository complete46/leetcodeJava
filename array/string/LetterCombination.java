package string;
import java.util.List;
import java.util.ArrayList;

public class LetterCombination {
	public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        String[] items = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        dfs(res, digits, digits.length(), items, new StringBuilder());
        return res;
    }
    
    public void dfs(List<String> res , String digits, int left, String[] items, StringBuilder sb) {
        if (left == 0) {
            res.add(sb.toString());
            return;
        }
        
        String s = items[digits.charAt(0) - '0'];
        
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sbNew = new StringBuilder(sb);
            sbNew.append(s.charAt(i));
            dfs(res, digits.substring(1), left - 1, items, sbNew);
        }
    }
}
