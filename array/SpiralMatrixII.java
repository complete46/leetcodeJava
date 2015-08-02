
public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        
        if (n == 0) {
            return mat;
        }
        
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        int i = 0;
        int j = 0;
        int pos = 0;

        for (int v = 1; v <= n * n; v++) {
            mat[i][j] = v;
            
            if (i + di[pos] == n || j + dj[pos] == n || i + di[pos] == -1 || j + dj[pos] == -1 || mat[i + di[pos]][j + dj[pos]] != 0) {
                pos = (pos + 1) % 4;
            }
            
            i += di[pos];
            j += dj[pos];
        }
        return mat;
    }
	
	public static void main(String[] args) {
		int n = 3;
		int[][] res = generateMatrix(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
}
