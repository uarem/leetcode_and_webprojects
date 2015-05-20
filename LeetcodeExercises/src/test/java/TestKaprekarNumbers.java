import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by uarem on 4/29/2015.
 */
public class TestKaprekarNumbers {

    @Test
    public void testKaprekarNumbers() {
        KaprekarNumbers k = new KaprekarNumbers();
        assertEquals(k.kaprekarNumbers(9), true);
        assertEquals(k.kaprekarNumbers(5), false);
        assertEquals(k.kaprekarNumbers(297), true);
        assertEquals(k.kaprekarNumbers(942), false);
    }
}
