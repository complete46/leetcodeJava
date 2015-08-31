package tree;

public class Dungeon {
	public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon.length == 0) {
            return 0;
        }
        
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        
        dp[row - 1][col - 1] = Math.max(1 - dungeon[row - 1][col - 1], 1);
        
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = Math.max(dp[i + 1][col - 1] - dungeon[i][col - 1], 1);
        }
        
        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = Math.max(dp[row - 1][i + 1] - dungeon[row - 1][i], 1);
        }
        
        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int down = Math.max(dp[i + 1][j] - dungeon[i][j], 1);
                int right = Math.max(dp[i][j + 1] - dungeon[i][j], 1);
                dp[i][j] = Math.min(down, right);
            }
        }
        
        return dp[0][0];
    }
}
