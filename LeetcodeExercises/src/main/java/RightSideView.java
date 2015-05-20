import java.util.*;

/**
 * Created by uarem on 4/18/2015.
 *
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class RightSideView {

    private Map<Integer, Integer> viewMap = new LinkedHashMap<Integer, Integer>();

    public List<Integer> rightSideView(TreeNode root) {
        travelTree(root, 0);
        List<Integer> result = new ArrayList<Integer>();

        for (int i=0; i<viewMap.size(); i++) result.add(viewMap.get(i));

        return result;
    }

    private void travelTree(TreeNode node, int level) {
        if (node == null)
            return;

        viewMap.put(level, node.val);

        travelTree(node.left, level+1);
        travelTree(node.right, level+1);
    }
}

