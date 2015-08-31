package tree;

public class NumberToWords {
	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		String[] suffix = { "Billion ", "Million ", "Thousand " };

		String res = helper(num % 1000);

		num /= 1000;
		if (num > 0 && num % 1000 > 0) {
			res = helper(num % 1000) + suffix[2] + res;
		}

		num /= 1000;
		if (num > 0 && num % 1000 > 0) {
			res = helper(num % 1000) + suffix[1] + res;
		}

		num /= 1000;
		if (num > 0 && num % 1000 > 0) {
			res = helper(num % 1000) + suffix[0] + res;
		}

		return res.trim();
	}

	public String helper(int num) {
		String[] digitString = new String[] { "Zero", "One", "Two", "Three",
				"Four", "Five", "Six", "Seven", "Eight", "Nine" };
		String[] teenString = new String[] { "Ten", "Eleven", "Twelve",
				"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Nineteen" };
		String[] tenString = new String[] { "", "", "Twenty", "Thirty",
				"Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
		String res = "";

		if (num > 99) {
			res += (digitString[num / 100] + " Hundred ");
		}
		num %= 100;

		if (num > 9 && num < 20) {
			res += (teenString[num - 10] + " ");
		} else {
			if (num > 19) {
				res += (tenString[num / 10] + " ");
			}
			num %= 10;
			if (num > 0) {
				res += (digitString[num] + " ");
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		NumberToWords nt = new NumberToWords();
		int num = 123;
		System.out.println(nt.numberToWords(num));
	}

}
