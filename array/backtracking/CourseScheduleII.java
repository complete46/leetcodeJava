package backtracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<Integer>());
        }
        
        int[] incoming = new int[numCourses];
        int[] res = new int[numCourses];
        
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            incoming[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i = 0; i < numCourses; i++) {
            if (incoming[i] == 0) {
                q.offer(i);
            }
        }
        
        int k = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            res[k++] = cur;
            
            for (int i : graph.get(cur)) {
                incoming[i]--;
                if (incoming[i] == 0) {
                    q.offer(i);
                }
            }
        }
        
        return k == numCourses ? res : new int[0];
    }
}
