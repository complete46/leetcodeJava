package hashtable_linkedList;

public class ReverseKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        
        int i = 0;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            i++;
            if (i % k == 0) {
                prev = reverse(prev, head.next);
                head = prev.next;
            } else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }
    
    public ListNode reverse(ListNode prev, ListNode next) {
        ListNode last = prev.next;
        ListNode cur = last.next;
        
        while (cur != next) {
            last.next = cur.next;
            cur.next = prev.next;
            prev.next = cur;
            cur = last.next;
        }
        
        return last;
    }
}
