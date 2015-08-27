package dynamicprogramming;
import java.util.*;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        q.offer(node);
        UndirectedGraphNode nodeClone = new UndirectedGraphNode(node.label);
        map.put(node, nodeClone);
        
        while (!q.isEmpty()) {
            UndirectedGraphNode original = q.poll();
            UndirectedGraphNode copy = map.get(original);
            
            List<UndirectedGraphNode> neigh = original.neighbors;
            
            for (UndirectedGraphNode n : neigh) {
                if (!map.containsKey(n)) {
                    UndirectedGraphNode nCopy = new UndirectedGraphNode(n.label);
                    copy.neighbors.add(nCopy);
                    map.put(n, nCopy);
                    q.offer(n);
                } else {
                    copy.neighbors.add(map.get(n));
                }
            }
        }
        
        return nodeClone;
    }
}
