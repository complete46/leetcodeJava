package string;

public class CompareVersion {
	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");

		int l1 = v1.length;
		int l2 = v2.length;
		int flag = 1;

		if (l1 > l2) {
			String[] t = v1;
			v1 = v2;
			v2 = t;
			
            int tt = l1;
            l1 = l2;
            l2 = tt;
			flag = -1;
		}

		int i = 0;
		for (i = 0; i < l1; i++) {
			if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
				return 1 * flag;
			} else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
				return -1 * flag;
			}
		}

		for (; i < l2; i++) {
			if (Integer.parseInt(v2[i]) != 0) {
				return -1 * flag;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		String v1 = "0";
		String v2 = "1";
		
		System.out.println(compareVersion(v1, v2));
	}
}
