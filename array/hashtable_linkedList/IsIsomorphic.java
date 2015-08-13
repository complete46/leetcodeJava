package hashtable_linkedList;

public class IsIsomorphic {
	public static boolean isIsomorphic(String s, String t) {
		int[] maps = new int[256];
        int[] mapt = new int[256];
        
        for (int i = 0; i < s.length(); i++) {
            if (maps[s.charAt(i)] != mapt[t.charAt(i)]) {
                return false;
            }
            
            maps[s.charAt(i)] = i + 11;
            mapt[t.charAt(i)] = i + 11;
        }
        
        return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("aba", "baa"));
	}
}
