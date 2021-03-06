package dynamicprogramming;

import java.util.Deque;
import java.util.ArrayDeque;

public class MaxSlidingWindow {
	public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || k == 0) {
            return new int[0];
        }
        
        int n = nums.length;
        
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        int pointer = 0;
        
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if (i >= k - 1) {
                res[pointer++] = nums[dq.peek()];
            }
        }
        
        return res;
    }
}
