public class FindMedianSortedArray {
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int l1 = nums1.length;
		int l2 = nums2.length;
		int l = l1 + l2;
		if (l % 2 == 0) {
			return ((double) findkth(nums1, nums2, 0, 0, l / 2 + 1) + findkth(
					nums1, nums2, 0, 0, l / 2)) / 2;
		}

		return findkth(nums1, nums2, 0, 0, l / 2 + 1);
	}

	public static int findkth(int[] A, int[] B, int as, int bs, int k) {
		if (A.length == as) {
			return B[bs + k - 1];
		}

		if (B.length == bs) {
			return A[as + k - 1];
		}

		if (k == 1) {
			return Math.min(A[as], B[bs]);
		}

		int a_val = (as + k / 2 - 1) >= A.length ? Integer.MAX_VALUE : A[as + k
				/ 2 - 1];
		int b_val = (bs + k / 2 - 1) >= B.length ? Integer.MAX_VALUE : B[bs + k
				/ 2 - 1];

		if (a_val > b_val) {
			return findkth(A, B, as, bs + k / 2, k - k / 2);
		} else {
			return findkth(A, B, as + k / 2, bs, k - k / 2);
		}
	}

	public static void main(String[] args) {
		int[] A = { 1, 3, 5, 7, 9, 11, 13, 15 };
		int[] B = { 2, 4, 6, 8, 10 };

		int[] C = {};
		int[] D = { 2, 3 };

		System.out.println(findMedianSortedArrays(C, D));
	}
}
