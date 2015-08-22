package string;

import java.util.Stack;

public class ReverseWords {
	public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<String> st = new Stack<String>();
        
        int l = 0;
        int r = 0;
        
        while (r < s.length()) {
            while (r < s.length() && s.charAt(r) != ' ') {
                r++;
            }
            
            st.push(s.substring(l, r));
            
            while (r < s.length() && s.charAt(r) == ' ') {
                r++;
            }
            l = r;
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!st.isEmpty()) {
            sb.append(st.pop() + " ");
        }
        
        return sb.toString().trim();
    }
	
	public static void main(String[] args) {
		String str = "  the sky  is   blue       ";
		System.out.println(reverseWords(str));
	}
}
