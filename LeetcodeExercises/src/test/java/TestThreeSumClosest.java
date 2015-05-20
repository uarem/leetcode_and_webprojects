import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by uarem on 4/27/2015.
 */
public class TestThreeSumClosest {
    ThreeSumClosest t;

    @Before
    public void init() {
        t = new ThreeSumClosest();
    }

    @Test
    public void test1() {
        assertEquals(t.threeSumClosest(new int[]{0, 1, 2}, 0), 3);
    }

    @Test
    public void test2() {
        assertEquals(t.threeSumClosest(new int[]{1,1,1,1}, 0), 3);
    }

    @Test
    public void test3() {
        assertEquals(t.threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2);
    }
}
