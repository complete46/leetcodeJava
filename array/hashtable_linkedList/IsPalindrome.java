package hashtable_linkedList;

public class IsPalindrome {
	public static boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        ListNode newHead = reverse(slow);
        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        
        return true;
    }
    
    public static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(0);
        
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        
        return dummy.next;
    }
    
    public static void main(String[] args) {
    	ListNode head = new ListNode(1);
    	
    	boolean res = isPalindrome(head);
    	System.out.println(res);
    }
}
