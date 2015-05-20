import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by uarem on 3/4/2015.
 *
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 *
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<List<Integer>>();

        List<List<Integer>> left = root.left == null ? new ArrayList<List<Integer>>() : levelOrderBottom(root.left);
        List<List<Integer>> right = root.right == null ? new ArrayList<List<Integer>>() : levelOrderBottom(root.right);

        List<List<Integer>> merge = new ArrayList<List<Integer>>();

        int maxSize = left.size() > right.size() ? left.size() : right.size();

        for (int i = 0; i < maxSize; i++) {
            List<Integer> levelMerge = new ArrayList<Integer>();
            if (left.size() - maxSize + i>= 0) levelMerge.addAll(left.get(left.size() - maxSize + i));
            if (right.size() - maxSize + i >= 0) levelMerge.addAll(right.get(right.size() - maxSize + i));
            merge.add(levelMerge);
        }

        merge.add(new ArrayList<Integer>(Arrays.asList(root.val)));
        return merge;
    }
}
