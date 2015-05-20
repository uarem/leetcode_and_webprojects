import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by uarem on 4/27/2015.
 */
public class TestThreeSum {

    @Test
    public void test() {
        ThreeSum t = new ThreeSum();
        assertEquals(t.threeSum(new int[]{-1, 0, 1, 2, -1, -4}).size(), 2);
    }



}
