package string;

import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

public class LargestNumber {
	public static String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < str.length; i++) {
        	str[i] = String.valueOf(nums[i]);
        }
        
        Comparator<String> comp = new Comparator<String>(){
        	public int compare(String a, String b) {
        		double x = Double.parseDouble(a + b);
        		double y = Double.parseDouble(b + a);
        		if (x == y) return 0;
        		return x > y ? -1 : 1;
        	}
        };
        
        Arrays.sort(str, comp);
        if (str[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for (String i : str) {
        	sb.append(i);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		int[] nums = {2147483647,2147483647,2147483646,9,1,8};
		int[] nums1 = {0, 0};
		System.out.println(largestNumber(nums));
	}
}
