package dynamicprogramming;

import java.util.Stack;

public class LargestRectangleArea {
	public int largestRectangleArea(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int h = (i == height.length ? 0 : height[i]);
            if (s.isEmpty() || height[s.peek()] <= h) {
                s.push(i);
            } else {
                int top = s.pop();
                max = Math.max(max, height[top] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        
        return max;
    }
}
