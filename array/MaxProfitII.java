
public class MaxProfitII {
	public int maxProfit(int[] prices) {
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            int t = prices[i] - prices[i - 1];
            res += t > 0 ? t : 0;
        }
        return res;
    }
}
