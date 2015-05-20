/**
 * Created by uarem on 3/30/2015.
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 *
 * Given a binary tree, populate each next pointer to point to its next right node.
 * If there is no next right node, the next pointer should be set to NULL.
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointers {

    public void connect(TreeLinkNode root) {
        if (root == null)
            return;

        if (root.left != null) {
            root.left.next = root.right;
            root.right.next = (root.next == null) ? null : root.next.left;
            connect(root.left);
            if (root.right != null) connect(root.right);
        }
    }
}
