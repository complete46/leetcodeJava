package tree;
import java.util.ArrayList;
import java.util.List;

public class LevelOrderII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {

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
			res.add(0, item);
		} else {
			item = (ArrayList<Integer>) res.get(res.size() - 1 - level);
		}

		item.add(0, root.val);

		level(res, root.right, level + 1);
		level(res, root.left, level + 1);

		return;
	}
}
