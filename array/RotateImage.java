public class RotateImage {
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] m1 = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				m1[i][j] = n * i + j + 1;
				System.out.print(m1[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

		rotate(m1);

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(m1[i][j] + " ");
			}
			System.out.println();
		}

	}
}
