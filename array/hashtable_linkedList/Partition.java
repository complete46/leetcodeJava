package hashtable_linkedList;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode slow = dummy;
        ListNode fast = dummy;

        while (fast.next != null) {
            if (fast.next.val < x) {
                if (fast != slow) {
                    ListNode temp = slow.next;
                    slow.next = fast.next;
                    fast.next = fast.next.next;
                    slow.next.next = temp;
                } else {
                    fast = fast.next;
                }
                slow = slow.next;
            } else {
                fast = fast.next;
            }
        }
        return dummy.next;
    }
}
