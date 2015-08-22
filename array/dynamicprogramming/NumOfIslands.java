package dynamicprogramming;

public class NumOfIslands {
	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;

		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					res++;
					dfs(grid, i, j, m, n);
				}
			}
		}

		return res;
	}

	public static void dfs(char[][] grid, int i, int j, int m, int n) {
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return;
		}

		if (grid[i][j] == '1') {
			grid[i][j] = '2';

			dfs(grid, i, j + 1, m, n);
			dfs(grid, i + 1, j, m, n);
			dfs(grid, i - 1, j, m, n);
			dfs(grid, i, j - 1, m, n);
		}
	}

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } };
		
		for (char[] cc : grid) {
			for (char c : cc) {
				System.out.print(c);
			}
			System.out.println();
		}
		
		System.out.println(numIslands(grid));
	}

}
