import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by uarem on 4/29/2015.
 */
public class TestAlienNumbers {

    @Test
    public void testAlienNumbers() {
        AlienNumbers a = new AlienNumbers();
        List<String> source = new ArrayList<String>(){{
            add("F");
            add("8");
            add("(");
            add("FF");
            add("F8");
            add("*");
            add("8F");
            add("88");
            add("Foo");
            add("FoF");
        }};

        List<String> target = new ArrayList<String>() {{
            add("0");
            add("1");
            add("2");
            add("3");
            add("4");
            add("5");
            add("6");
            add("7");
            add("8");
            add("9");
        }};

        assertEquals((a.alienNumbers("FF**(FoF", source, target)), 35529);
    }

}
