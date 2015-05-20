import org.junit.Test;

/**
 * Created by uarem on 5/2/2015.
 */
public class TestBinaryTreeToLinkedLists {

    @Test
    public void testBinaryTreeToLinkedList() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);
        TreeNode a10 = new TreeNode(10);
        TreeNode a11 = new TreeNode(11);
        TreeNode a12 = new TreeNode(12);

        a1.left = a2;
        a2.left = a3;
        a2.right = a4; // a4 - a6
        a3.left = a5;
        a3.right = a6;
        a5.left = a7;
        a5.right = a8;
        a6.left = a9;
        a9.right = a10;
        a4.left = a11;
        a1.right = a12;

        BinaryTreeToLinkedLists b = new BinaryTreeToLinkedLists();
        b.binaryTreeToLinkedLists(a1, null, 0);
    }
}
