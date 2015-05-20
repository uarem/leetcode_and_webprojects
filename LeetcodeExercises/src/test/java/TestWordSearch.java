import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by uarem on 5/17/2015.
 */
public class TestWordSearch {

    @Test
    public void testSearch() {
        WordSearch w = new WordSearch();
        char[][] input = new char[3][4];
        input[0] = "ABCE".toCharArray();
        input[1] = "SFCS".toCharArray();
        input[2] = "ADEE".toCharArray();
        char[][] input2 = new char[1][2];
        input2[0] = "AA".toCharArray();
        assertEquals(w.exist(input, "ABCC"), true);
        assertEquals(w.exist(input, "ABCCC"), false);
        assertEquals(w.exist(input, "SEE"), true);
        assertEquals(w.exist(input2, "AAA"), false);
    }
}
