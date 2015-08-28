package dynamicprogramming;

import java.util.Stack;

public class LongestValidParenthesis {
	public class Solution {
	    public int longestValidParentheses(String s) {
	        int max = 0;
	        int len = s.length();
	        
	        Stack<Integer> st = new Stack<Integer>();
	        
	        for (int i = 0; i < len; i++) {
	            if (s.charAt(i) == '(') {
	                st.push(i);
	            } else {
	                if (!st.isEmpty() && s.charAt(st.peek()) == '(') {
	                    st.pop();
	                } else {
	                    st.push(i);
	                }
	            }
	        }
	        
	        if (st.isEmpty()) return len;
	        
	        int r = len;
	        int l = 0;
	        while (!st.isEmpty()) {
	            l = st.pop();
	            max = Math.max(max, r - l - 1);
	            r = l;
	        }
	        
	        max = Math.max(max, r);
	        
	        return max;
	    }
	}
}
