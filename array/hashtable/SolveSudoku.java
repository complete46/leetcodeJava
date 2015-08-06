package hashtable;

public class SolveSudoku {
	public void solveSudoku(char[][] board) {
        int[] empty = new int[81];
        int len = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    empty[len++] = i * 9 + j;
                }
            }
        }
        
        dfs(empty, board, 0, len);
    }
    
    public boolean dfs(int[] empty, char[][] board, int cur, int len){
        if (cur == len) {
            return true;
        }
        int index = empty[cur];
        int row = index / 9;
        int col = index % 9;
        
        for (int v = 1; v <= 9; v++) {
            if (validate(board, row, col, (char)(v + '0'))) {
                board[row][col] = (char)(v + '0');
                if (dfs(empty, board, cur + 1, len)) {
                    return true;
                }
                board[row][col] = '.';
            }
        }
        
        return false;
    }
    
    public boolean validate(char[][] board, int i, int j, char num) {
        for (int m = 0; m < 9; m++) {
            if (board[m][j] == num) {
                return false;
            }
        }
        
        for (int m = 0; m < 9; m++) {
            if (board[i][m] == num) {
                return false;
            }
        }
        
        for (int m = 0; m < 9; m++) {
            int row = i / 3 * 3 + m / 3;
            int col = j / 3 * 3 + m % 3;
            
            if (board[row][col] == num) {
                return false;
            }
        }
        
        return true;
    }
}
