import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by uarem on 4/26/2015.
 */
public class TestLandAndBasin {

    @Test
    public void testLandAndBasin() {
        int[][] array = {{1,5,2}, {2,4,7}, {3,6,9}};

        LandAndBasin lnb = new LandAndBasin(3, 3, array);
        char[][] result = lnb.landAndBasin();
        assertEquals(result.length, 3);
        assertEquals(Arrays.equals(result[0], new char[]{'A','A','B'}), true);
        assertEquals(Arrays.equals(result[1], new char[]{'A','A','B'}), true);
        assertEquals(Arrays.equals(result[2], new char[]{'A','A','A'}), true);
    }

    @Test
    public void testLandAndBasin5x5() {
        int[][] array = {{1,0,2,5,8}, {2,3,4,7,9}, {3,5,7,8,9},{1,2,5,4,3},{3,3,5,2,1}};

        LandAndBasin lnb = new LandAndBasin(5, 5, array);
        char[][] result = lnb.landAndBasin();
        assertEquals(result.length, 5);
        assertEquals(Arrays.equals(result[0], new char[]{'A','A','A','A','A'}), true);
        assertEquals(Arrays.equals(result[1], new char[]{'A','A','A','A','A'}), true);
        assertEquals(Arrays.equals(result[2], new char[]{'B','B','A','C','C'}), true);
        assertEquals(Arrays.equals(result[3], new char[]{'B','B','B','C','C'}), true);
        assertEquals(Arrays.equals(result[4], new char[]{'B','B','C','C','C'}), true);
    }

    @Test
    public void testLandAndBasin4x4() {
        int[][] array = {{0,2,1,3}, {2,1,0,4}, {3,3,3,3}, {5,5,2,1}};

        LandAndBasin lnb = new LandAndBasin(4, 4, array);
        char[][] result = lnb.landAndBasin();
        assertEquals(result.length, 4);
        assertEquals(Arrays.equals(result[0], new char[]{'A','A','B','B'}), true);
        assertEquals(Arrays.equals(result[1], new char[]{'A','B','B','B'}), true);
        assertEquals(Arrays.equals(result[2], new char[]{'A','B','B','C'}), true);
        assertEquals(Arrays.equals(result[3], new char[]{'A','C','C','C'}), true);
    }
}
