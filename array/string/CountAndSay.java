package string;

public class CountAndSay {
	public static String countAndSay(int n) {
        String res = "1";
        
        for (int i = 1; i < n; i++) {
            res = count(res);
        }
        
        return res;
    }
    
    public static String count(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            int k = 0;
            while (i + k < s.length() && s.charAt(i + k) == c) {
                k++;
            }
            sb.append(k);
            sb.append(c);
            i += k;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
    	System.out.println(count("21"));
    }
}
