package hashtable_linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
public class MergeKLists {


	public static ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length,
				new Comparator<ListNode>() {
					public int compare(ListNode l1, ListNode l2) {
						return l1.val - l2.val;
					}
				});

		for (int i = 0; i < lists.length; i++) {
			if (lists[i] != null) {
				pq.offer(lists[i]);
			}
		}

		ListNode head = new ListNode(0);
		ListNode cur = head;

		while (!pq.isEmpty()) {
			ListNode t = pq.poll();
			cur.next = t;
			if (t.next != null) {
				pq.offer(t.next);
			}
			cur = cur.next;
		}

		return head.next;
	}

	public static void main(String[] args) {
		ListNode[] lists = {};
		mergeKLists(lists);
	}

}
