package hashtable_linkedList;

public class CountPrimes {

	public static int countPrimes(int n) {
		int res = 0;
		boolean[] pri = new boolean[n + 1];
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (isPrime(i)) {
				int k = 2;
				while (k * i < n) {
					pri[k * i] = true;
					k++;
				}
			}
		}
		for (int i = 2; i < pri.length; i++) {
			System.out.println(pri[i]);
		}
		for (int i = 2; i < n; i++) {
			res += pri[i] ? 0 : 1;
		}
		return res;
	}

	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(countPrimes(5));
	}
}
