import java.util.List;
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {

        int k = triangle.size();
        int[] dp = new int[k];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = triangle.get(k - 1).get(i);
        }
        for (int i = k - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        
        return dp[0];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
