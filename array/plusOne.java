public class plusOne {
    public static int[] solution(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int n = digits.length;
        int flag = 0;
        int[] res = new int[n];
        digits[n - 1]++;

        for (int i = n - 1; i >= 0; i--) {
            res[i] = (digits[i] + flag) % 10;
            flag = (digits[i] + flag) / 10;
        }

        if (flag == 1) {
            int[] newRes = new int[n + 1];
            for (int i = 0; i < n; i++) {
                newRes[i + 1] = res[i];
            }
            newRes[0] = 1;
            return newRes;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] test = {9, 9, 9, 9};

        int[] res = solution(test);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
        }

        System.out.println('\n');
    }
}
