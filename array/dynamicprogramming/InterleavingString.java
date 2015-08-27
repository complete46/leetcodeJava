package dynamicprogramming;

public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        int l1 = s1.length();
        int l2 = s2.length();
        
        boolean[][] match = new boolean[l1 + 1][l2 + 1];
        match[0][0] = true;
        int i = 1;
        
        while (i <= l1 && s3.charAt(i - 1) == s1.charAt(i - 1)) {
            match[i][0] = true;
            i++;
        }
        
        i = 1;
        while (i <= l2 && s3.charAt(i - 1) == s2.charAt(i - 1)) {
            match[0][i] = true;
            i++;
        }
        
        for (i = 1; i <= l1; i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= l2; j++) {
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                
                if (c1 == c3) {
                    match[i][j] = match[i - 1][j];
                }
                
                if (c2 == c3) {
                    match[i][j] = match[i][j - 1] || match[i][j];
                }
            }
        }
        return match[l1][l2];
    }
}
