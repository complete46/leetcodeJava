package hashtable;

public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;
		ListNode temp = null;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			temp = slow;
			slow = slow.next;
		}

		if (temp != null) {
			temp.next = null;
		} else {
			head = null;
		}

		TreeNode root = new TreeNode(slow.val);
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(slow.next);

		return root;
	}
}
