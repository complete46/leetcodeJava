package tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrder {
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        level(res, root, 0);
        
        return res;
    }
    
    public void level(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        
        ArrayList<Integer> item;
        if (level == res.size()) {
            item = new ArrayList<Integer>();
            res.add(item);
        } else {
            item = (ArrayList<Integer>)res.get(level);
        }
        
        item.add(root.val);
        
        level(res, root.left, level + 1);
        level(res, root.right, level + 1);
        
        return;
    }
}
