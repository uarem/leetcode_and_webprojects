/**
 * Created by uarem on 2/12/2015.
 *
 * https://leetcode.com/problems/minimum-depth-of-binary-tree/
 *
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;

        int l_value = root.left != null ? minDepth (root.left) + 1 : 1;
        int r_value = root.right != null ? minDepth (root.right) + 1 : 1;

        return l_value == r_value ? l_value : l_value == 1 ? r_value : r_value == 1 ? l_value : l_value < r_value ? l_value : r_value;

    }
}
