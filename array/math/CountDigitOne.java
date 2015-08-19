package math;

public class CountDigitOne {
	public static int countDigitOne(int n) {
        int res = 0;
        
        for (long m = 1; m <= n; m *= 10) {
            int a = n / (int)m;
            int b = n % (int)m;
            
            int c = a % 10;
            
            if (c > 1) {
                res += (a / 10 + 1) * m;
            } else if (c == 1) {
                res += a / 10 * m + b + 1;
            } else {
                res += a / 10 * m;
            }
            System.out.println("Cur res is " + res + " " + a + " " + b + " "+ c);
        }
        
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(countDigitOne(1410065408));
	}
}
