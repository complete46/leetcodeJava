package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
	public String serialize(TreeNode root) {
        // write your code here
		if (root == null) return "#";
        StringBuilder res = new StringBuilder();
        boolean end = false;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!end) {
        	end = true;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		TreeNode cur = q.poll();
        		String s = cur == null ? "#" : String.valueOf(cur.val);
        		res.append(res.length() != 0 ? "," + s : s);
        		
        		if (cur != null) {
        			if (cur.left != null || cur.right != null) {
        				end = false;
        			}
        			q.offer(cur.left);
        			q.offer(cur.right);
        		}
        	}
        }
        
        return res.toString();
    }
    
    
    
    public boolean isLeaf(TreeNode root) {
    	return root.left == null && root.right == null;
    }
    

    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.equals("")) return null;
        String[] nodes = data.split(",");
        TreeNode root = build(nodes, 1);
        
        return root;
    }
    
    public TreeNode build(String[] nodes, int i) {
        if (i > nodes.length || nodes[i - 1].equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(nodes[i - 1]));
        root.left = build(nodes, 2 * i);
        root.right = build(nodes, 2 * i + 1);
        
        return root;
    }
    
    
    
    public static void main(String[] args) {
    	SerializeTree st = new SerializeTree();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.right = new TreeNode(3);
    	root.right.right = new TreeNode(7);
    	
    	System.out.println(st.serialize(root));
    }
}
