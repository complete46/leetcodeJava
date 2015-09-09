package hashtable_linkedList;

import java.util.PriorityQueue;
import java.util.Comparator;

public class AddTwoNumbers {
	PriorityQueue<ListNode> pq = new PriorityQueue<>(1, new Comparator<ListNode>() {
		public int compare(ListNode n1, ListNode n2) {
			return n1.val - n2.val;
		}
	});
    

}
