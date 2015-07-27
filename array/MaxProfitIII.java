public class MaxProfitIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int[] dpl = new int[prices.length];
		int[] dpr = new int[prices.length];
		dpl[0] = 0;
		dpr[dpr.length - 1] = 0;

		int mp = prices[0];
		for (int i = 1; i < dpl.length; i++) {
			mp = Math.min(mp, prices[i]);
			dpl[i] = Math.max(dpl[i - 1], prices[i] - mp);
		}

		mp = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			mp = Math.max(mp, prices[i]);
			dpr[i] = Math.max(dpr[i + 1], mp - prices[i]);
		}

		int profit = 0;
		for (int i = 0; i < dpl.length; i++) {
			profit = Math.max(profit, dpl[i] + dpr[i]);
		}

		return profit;
	}
}
