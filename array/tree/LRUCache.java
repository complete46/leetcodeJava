package tree;

import java.util.HashMap;

public class LRUCache {

	class DoubleLinkedListNode {
		DoubleLinkedListNode prev;
		DoubleLinkedListNode next;
		int key;
		int value;

		public DoubleLinkedListNode(int key, int value) {
			this.prev = null;
			this.next = null;
			this.key = key;
			this.value = value;
		}
	}

	int capacity;
	int size;
	HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	DoubleLinkedListNode head;
	DoubleLinkedListNode tail;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.size = 0;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		} else {
			DoubleLinkedListNode cur = map.get(key);
			remove(cur);
			setHead(cur);
			return cur.value;
		}
	}

	public void set(int key, int value) {
		if (!map.containsKey(key)) {
			DoubleLinkedListNode cur = new DoubleLinkedListNode(key, value);
			map.put(key, cur);
            setHead(cur);
			size++;
			if (size > capacity) {
				map.remove(tail.key);
				remove(tail);
			}
		} else {
			DoubleLinkedListNode cur = map.get(key);
			cur.value = value;
			remove(cur);
			setHead(cur);
		}
	}

	public void remove(DoubleLinkedListNode node) {
		DoubleLinkedListNode prev = node.prev;
		DoubleLinkedListNode next = node.next;

		if (prev != null) {
			prev.next = next;
		} else {
			head = next;
		}

		if (next != null) {
			next.prev = prev;
		} else {
			tail = prev;
			if (tail != null) {
				tail.next = null;
			}
		}
	}

	public void setHead(DoubleLinkedListNode node) {
		node.next = head;
		node.prev = null;

		if (head != null) {
			head.prev = node;
		}

		head = node;

		if (tail == null) {
			tail = node;
		}
	}

}
