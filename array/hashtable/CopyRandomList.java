package hashtable;

public class CopyRandomList {
	class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) {label = x;}
	}
	
	public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        
        RandomListNode cur = head;
        
        while (cur != null) {
            RandomListNode copyCur = new RandomListNode(cur.label);
            copyCur.next = cur.next;
            cur.next = copyCur;
            cur = cur.next.next;
        }
        
        cur = head;
        RandomListNode copyCur = cur.next;
        RandomListNode copyHead = cur.next;
        
        while (cur != null) {
            if (cur.random != null) {
                copyCur.random = cur.random.next;
            }
            cur = copyCur.next;
            if (cur != null) {
                copyCur = cur.next;
            }    
        }
        
        cur = head;
        copyCur = copyHead;
        
        while (cur != null) {
            cur.next = cur.next.next;
            if (copyCur.next != null) {
                copyCur.next = copyCur.next.next;
            }
            copyCur = copyCur.next;
            cur = cur.next;
        }
        
        return copyHead;
    }
}
