package backtracking;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		int m = board.length;
		int n = board[0].length;

		boolean[][] visited = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (bfs(board, visited, word, i, j, 0)) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean bfs(char[][] board, boolean[][] visited, String word, int i,
			int j, int idx) {
		if (idx == word.length()) {
			for (int x = 0; x < board.length; x++) {
				for (int y = 0; y < board[0].length; y++) {
					if (visited[x][y]) {
						System.out.print(board[x][y]);
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			return true;
		}

		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
				|| visited[i][j] == true || word.charAt(idx) != board[i][j]) {
			return false;
		}

		visited[i][j] = true;

		boolean res = bfs(board, visited, word, i + 1, j, idx + 1)
				|| bfs(board, visited, word, i - 1, j, idx + 1)
				|| bfs(board, visited, word, i, j + 1, idx + 1)
				|| bfs(board, visited, word, i, j - 1, idx + 1);

		visited[i][j] = false;

		return res;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		String word = "ABCCED";
		
		exist(board, word);
	}
}
