package dynamicprogramming;

public class ShortestPalidrome {
	public String shortestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        
        String res = "";
        int center = (s.length() - 1) / 2;
        
        for (int i = center; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                if ((res = check(s, i, i + 1)) != null) return res;
            }
            
            if ((res = check(s, i, i)) != null) return res;
        }
        
        return res;
    }
    
    public String check(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(r) == s.charAt(l)) {
            l--;
            r++;
        }
        
        if (l >= 0) return null;
        
        StringBuilder sb = new StringBuilder(s.substring(r));
        sb.reverse();
        
        return sb.append(s).toString();
    }
}
