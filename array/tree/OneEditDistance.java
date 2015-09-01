package tree;

public class OneEditDistance {
	public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
        
        if (s.length() == t.length()) {
            return isModify(s, t);
        }
        
        return s.length() > t.length() ? isDel(s, t) : isDel(t, s);
    }
    
    public boolean isModify(String s, String t) {
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) diff++;
        }
        return diff == 1;
    }
    
    public boolean isDel(String s, String t) {
        for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
            if (s.charAt(i) != t.charAt(j)) {
                return s.substring(i + 1).equals(t.substring(j));
            }
        }
        
        return true;
    }
}
