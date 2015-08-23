package hashtable_linkedList;

public class SortList {
	public ListNode sortList(ListNode head) {
		return mergeSort(head);
	}

	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode head2 = slow.next;
		ListNode head1 = head;
		slow.next = null;
		head1 = mergeSort(head1);
		head2 = mergeSort(head2);

		return merge(head1, head2);

	}

	public ListNode merge(ListNode head1, ListNode head2) {
		ListNode pre = new ListNode(0);
		ListNode dummy = pre;
		pre.next = head1;

		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				head1 = head1.next;
			} else {
				ListNode next = head2.next;
				head2.next = pre.next;
				pre.next = head2;
				head2 = next;
			}

			pre = pre.next;
		}

		if (head2 != null) {
			pre.next = head2;
		}

		return dummy.next;
	}
	
	public static int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        
        return res;
    }
	
	public int findThreeTime(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
	
    synchronized public static boolean buy(int amout) {
        return false;
    }
	
	public static void main(String[] args) {
		int res = 1 * 432 + 6 * 8 + 4 * 72 + 6 * 32 + 6 * 12 + 2 * 288 + 4 * 108 + 6 * 48;
		int[] nums = {88, 459, 5262, 88, -17, 677, 88, 667, -17, 459, 5262};
		System.out.println(singleNumber(nums));
		System.out.println(88  ^ 88  ^ 677 ^ 88 ^ 667   ^ 5262);
	}
}
