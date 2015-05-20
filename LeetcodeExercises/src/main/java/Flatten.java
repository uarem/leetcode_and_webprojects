/**
 * Created by uarem on 4/26/2015.
 *
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 *
 * Given a binary tree, flatten it to a linked list in-place.
 */
public class Flatten {

    public void flatten(TreeNode root) {
        subFlatten(root);
        System.out.println("end");
    }

    private TreeNode subFlatten(TreeNode root) {

        if (root == null)
            return root;
        TreeNode rightNode = root.right;
        TreeNode lastNode = root;
        if (root.left != null) {
            root.right = root.left;
            root.left = null;
            lastNode = subFlatten(root.right);
        }
        if (rightNode != null) {
            lastNode.right = rightNode;
            lastNode.left = null;
            lastNode = subFlatten(rightNode);
        }

        // return the last node
        return lastNode;
    }


}
