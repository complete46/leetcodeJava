import java.util.List;
import java.util.ArrayList;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return res;
        }
        
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        int i = 0;
        int j = 0;
        
        int row = matrix.length;
        int col = matrix[0].length;
        
        int pastRow = 0;
        int pastCol = 0;
        
        int left;
        
        int pos = 0;
        int step = 0;
        while (true) {
            if (di[pos] == 0) {
                left = col - pastCol;
            } else {
                left = row - pastRow;
            }
            
            if (left <= 0) {
                break;
            }
            
            res.add(matrix[i][j]);
            step++;
            
            if (step == left) {
                pastCol += di[pos] == 0 ? 0 : 1;
                pastRow += dj[pos] == 0 ? 0 : 1;
                step = 0;
                pos = (pos + 1) % 4;
            }
            
            i += di[pos];
            j += dj[pos];
        }
        return res;
    }
	
	public static void main(String[] args) {
		
	}
}
