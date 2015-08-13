package hashtable_linkedList;
import java.util.HashSet;

public class HappyNumber {
	public static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        if (n == 1) {
            return true;
        }
        
        while (true) {
            int ne = next(n);
            if (ne == 1) {
                return true;
            }
            if (set.contains(ne)) {
                break;
            } else {
                set.add(ne);
            }
            n = ne;
        }
        
        return false;
    }
    
    public static int next(int n) {
        int res = 0;
        while (n > 0) {
            res += (n % 10) * (n % 10);
            n /= 10;
        }
        System.out.println(res);
        return res;
    }
    
    public static void main(String[] args) {
    	System.out.println(isHappy(7));
    }
}
