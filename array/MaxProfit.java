
public class MaxProfit {
	public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        
        int profit = 0;
        int minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            minPrice = Math.min(prices[i], minPrice);
            profit = Math.max(profit, prices[i] - minPrice);
        }
        
        return profit;
    }
}
