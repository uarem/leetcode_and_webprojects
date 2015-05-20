import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * Created by uarem on 4/18/2015.
 */
public class TestRightSideView {

    @Test
    public void testRightSideView() {
        RightSideView r = new RightSideView();

        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(6);

        a.left = b;
        a.right = c;
        b.right = e;
        e.left = f;
        c.right = d;

        assertEquals(new int[]{1, 3, 4, 6}, r.rightSideView(a).toArray());
    }
}