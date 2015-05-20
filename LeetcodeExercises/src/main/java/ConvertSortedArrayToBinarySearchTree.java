import java.util.Arrays;

/**
 * Created by uarem on 4/21/2015.
 */
public class ConvertSortedArrayToBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0)
            return null;
        int half = num.length / 2;
        TreeNode me = new TreeNode(num[half]);
        me.left = (half > 0) ? sortedArrayToBST(Arrays.copyOf(num, half)) : null;
        me.right = (half+1 < num.length) ? sortedArrayToBST(Arrays.copyOfRange(num, half + 1, num.length)) : null;
        return me;
    }
}