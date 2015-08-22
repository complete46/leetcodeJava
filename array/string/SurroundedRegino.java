package string;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegino {
	public class Solution {
	    public void solve(char[][] board) {
	        if (board == null || board.length <= 1 || board[0].length <= 1) {
	            return;
	        }
	        
	        for (int i = 0; i < board.length; i++) {
	            bfs(board, i, 0);
	            bfs(board, i, board[0].length - 1);
	        }
	        
	        for (int i = 1; i < board[0].length - 1; i++) {
	            bfs(board, 0, i);
	            bfs(board, board.length - 1, i);
	        }
	        
	        for (int i = 0; i < board.length; i++) {
	            for (int j = 0; j < board[0].length; j++) {
	                if (board[i][j] == 'O') board[i][j] = 'X';
	                if (board[i][j] == '#') board[i][j] = 'O';
	            }
	        }
	        
	        return;
	    }
	    
	    public void bfs(char[][] board, int i, int j) {
	        if (board[i][j] != 'O') {
	            return;
	        }
	        
	        board[i][j] = '#';
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        int code = i * board[0].length + j;
	        q.offer(code);
	        
	        while (!q.isEmpty()) {
	            code = q.poll();
	            int row = code / board[0].length;
	            int col = code % board[0].length;
	            
	            if (row - 1 >= 0 && board[row - 1][col] == 'O') {
	                q.offer((row - 1) * board[0].length + col);
	                board[row - 1][col] = '#';
	            }
	            
	            if (row + 1 < board.length && board[row + 1][col] == 'O') {
	                q.offer((row + 1) * board[0].length + col);
	                board[row + 1][col] = '#';
	            }
	            
	            if (col - 1 >= 0 && board[row][col - 1] == 'O') {
	                q.offer(row * board[0].length + col - 1);
	                board[row][col - 1] = '#';
	            }
	            
	            if (col + 1 < board[0].length && board[row][col + 1] == 'O') {
	                q.offer(row * board[0].length + col + 1);
	                board[row][col + 1] = '#';
	            }
	        }
	    }
	}
}
