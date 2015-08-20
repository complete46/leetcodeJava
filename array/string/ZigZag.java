package string;

public class ZigZag {
	public String convert(String s, int numRows) {
        int l = s.length();
        char[] c = s.toCharArray();
        
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) sb[i] = new StringBuilder();
        
        int i = 0;
        while (i < l) {
            for (int idx = 0; idx < numRows && i < l; idx++) {
                sb[idx].append(c[i++]);
            }
            
            for (int idx = numRows - 2; idx >= 1 && i < l; idx--) {
                sb[idx].append(c[i++]);
            }
        }
        
        for (int idx = 1; idx < numRows; idx++) {
            sb[0].append(sb[idx]);
        }
        
        return sb[0].toString();
    }
}
