import org.junit.Test;

/**
 * Created by uarem on 4/26/2015.
 */
public class TestFlatten {

    @Test
    public void testFlatten() {
        TreeNode a1 = new TreeNode(1);
        TreeNode a2 = new TreeNode(2);
        TreeNode a3 = new TreeNode(3);
        TreeNode a4 = new TreeNode(4);
        TreeNode a5 = new TreeNode(5);
        TreeNode a6 = new TreeNode(6);
        TreeNode a7 = new TreeNode(7);
        TreeNode a8 = new TreeNode(8);
        TreeNode a9 = new TreeNode(9);

        a1.left = a2;
        a2.left = a3;
        a2.right = a4;
        a4.left = a5;
        a1.right = a6;
        a6.left = a7;
        a7.left = a8;
        a6.right = a9;

        Flatten f = new Flatten();
        f.flatten(a1);
    }
}
