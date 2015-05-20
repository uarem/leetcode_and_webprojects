import java.util.*;

/**
 * Created by uarem on 5/2/2015.
 */
public class BinaryTreeToLinkedLists {

    public void binaryTreeToLinkedLists (TreeNode root, List<LinkedList<Integer>> lists, int height) {
        if (height == 0) {
            lists = new ArrayList<LinkedList<Integer>>();
        }

        if (lists.size() > height) {
            lists.get(height).add(root.val);
        } else {
            LinkedList<Integer> newList = new LinkedList<Integer>();
            newList.add(root.val);
            lists.add(newList);
        }

        if (root.left != null) {
            binaryTreeToLinkedLists(root.left, lists, height+1);
        }
        if (root.right != null) {
            binaryTreeToLinkedLists(root.right, lists, height+1);
        }
    }

    public TreeNode findCommonAncestors(TreeNode a1, TreeNode a2) {
        Map<Integer, TreeNode> a1path = new HashMap<Integer, TreeNode>();
        Map<Integer, TreeNode> a2path = new HashMap<Integer, TreeNode>();

        return a1;
    }

    private void buildPath(Map<Integer, TreeNode> path, TreeNode root) {
        ArrayList list = new ArrayList();
        list.add(5);
    }
}