
public class MinPathSum {
	public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = grid[0][i] + dp[i - 1];
        }
        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
            }
        }
        
        return dp[n - 1];
    }
}
