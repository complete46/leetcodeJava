package backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;


public class CourseSchedule {
	public class Solution {
	    public boolean canFinish(int numCourses, int[][] prerequisites) {
	        List<List<Integer>> graph = new ArrayList<List<Integer>>();
	        int[] incoming = new int[numCourses];
	        int count = 0;
	        
	        for (int i = 0; i < numCourses; i++) {
	            graph.add(new ArrayList<Integer>());
	        }
	        
	        for (int i = 0; i < prerequisites.length; i++) {
	            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
	            incoming[prerequisites[i][1]]++;
	        }
	        
	        Queue<Integer> q = new LinkedList<Integer>();
	        
	        for (int i = 0; i < incoming.length; i++) {
	            if (incoming[i] == 0) {
	                q.offer(i);
	                count++;
	            }
	        }
	        
	        while (!q.isEmpty()) {
	            int cur = q.poll();
	            for (int i = 0; i < graph.get(cur).size(); i++) {
	                int to = graph.get(cur).get(i);
	                incoming[to]--;
	                if (incoming[to] == 0) {
	                    count++;
	                    q.offer(to);
	                }
	            }
	        }
	        
	        return count == numCourses;
	    }
	}
}
