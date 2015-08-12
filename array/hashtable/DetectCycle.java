package hashtable;

public class DetectCycle {
	public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if (fast == slow) {
                ListNode cur = head;
                while (cur != fast) {
                    cur = cur.next;
                    fast = fast.next;
                }
                
                return cur;
            }
        }
        
        return null;
    }
}
