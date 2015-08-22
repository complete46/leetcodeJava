package string;

import java.util.List;
import java.util.ArrayList;

public class DiffWaysToCompute {
	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '+' || input.charAt(i) == '-'
					|| input.charAt(i) == '*') {
				String s1 = input.substring(0, i);
				String s2 = input.substring(i + 1);

				List<Integer> res1 = diffWaysToCompute(s1);
				List<Integer> res2 = diffWaysToCompute(s2);

				for (int k1 : res1) {
					for (int k2 : res2) {
						switch (input.charAt(i)) {
						case '+':
							res.add(k1 + k2);
							break;
						case '-':
							res.add(k1 - k2);
							break;
						case '*':
							res.add(k1 * k2);
							break;
						}
					}
				}
			}
		}

		if (res.size() == 0) {
			res.add(Integer.valueOf(input));
		}

		return res;
	}

	public static void main(String[] args) {
		String str = "2*3-4*5";
		List<Integer> res = diffWaysToCompute(str);
		for (int k : res) {
			System.out.print(k + " ");
		}
	}
}
