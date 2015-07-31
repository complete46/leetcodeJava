
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int i = 0;
        int j = matrix.length * matrix[0].length - 1;
        while (i <= j) {
            int mid = (i + j) / 2;
            int c = matrix[mid / n][mid % n];
            if (c == target) {
                return true;
            }
            
            if (c > target) {
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }
        return false;
    }
}
