package hashtable;
import java.util.HashMap;

public class FractionToDecimal {
	public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();
        
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            res.append("-");
        }
        
        long n = Math.abs((long)numerator);
        long d = Math.abs((long)denominator);
        
        System.out.println(n + " " + d);
        
        res.append(n / d);
        long left = n % d;
        if (left == 0) {
            return res.toString();
        }
        
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        
        while (left != 0) {
        	System.out.println(res.toString());
            if (!map.containsKey(left)) {
                map.put(left, res.length());
                left *= 10;
                res.append(left / d);
                left %= d;
            } else {
                res.insert(map.get(left), "(");
                res.append(")");
                break;
            }
        }
        
        return res.toString();
    }
	
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(-1, -Integer.MIN_VALUE));
	}
}
