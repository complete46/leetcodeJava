package dynamicprogramming;

public class RegularExpression {
	public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        
        for (int i = 1; i <= p.length(); i++) {
            if (p.charAt(i - 1) != '*') {
                dp[0][i] = false;
            } else {
                dp[0][i] = dp[0][i - 2];
            }
        }
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '*') {
                    dp[i][j] = (dp[i - 1][j - 1] && (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.'));
                } else {
                    if (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')) {
                        dp[i][j] = true;
                    } else if (dp[i][j - 1] || dp[i][j - 2]) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        
        return dp[s.length()][p.length()];
    }
}
