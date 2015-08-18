package dynamicprogramming;

public class NameDecoding {
	public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        
        int[] dp = new int[s.length() + 1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s.substring(i - 1, i))) {
                dp[i] += dp[i - 1];
            }
            
            if (isValid(s.substring(i - 2, i))) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[s.length()];
    }
    
    public boolean isValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        
        int n = Integer.parseInt(s);
        
        return n > 0 && n <= 26;
    }
}
