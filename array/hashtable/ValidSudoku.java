package hashtable;

import java.util.HashSet;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < 9; i++) {
			set.clear();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j] - '0')) {
						return false;
					} else {
						set.add(board[i][j] - '0');
					}
				}
			}
		}

		for (int j = 0; j < 9; j++) {
			set.clear();
			for (int i = 0; i < 9; i++) {
				if (board[i][j] != '.') {
					if (set.contains(board[i][j] - '0')) {
						return false;
					} else {
						set.add(board[i][j] - '0');
					}
				}
			}
		}

		for (int i = 0; i < 9; i++) {
			set.clear();
			for (int j = 0; j < 9; j++) {
				if (board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.') {
					if (set.contains(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] - '0')) {
						return false;
					} else {
						set.add(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] - '0');
					}
				}
			}
		}

		return true;
	}
}
