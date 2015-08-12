package hashtable;

public class RotateRight {
	public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        int l = 0;
        while (fast != null) {
            l++;
            fast = fast.next;
        }
        fast = head;
        k = k % l;
        if (k == 0) {
            return head;
        }
        
        while (k-- > 0) {
            if (fast == null) {
                fast = head;
            } else {
                fast = fast.next;
            }
        }
        
        if (fast == null) {
            return head;
        }
        
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
	}
}
