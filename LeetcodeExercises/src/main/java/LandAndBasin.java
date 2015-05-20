import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by uarem on 4/26/2015.
 *
 * http://www.careercup.com/question?id=15380670
 *
 * Palantir Coding Interview Question
 */
public class LandAndBasin {
    int[][] array;
    char[][] result;

    public LandAndBasin(int j, int i, int[][] input) {
        array = input;
        result = new char[j][i];
    }

    private String getKey (int j, int i) {
        return j+","+i;
    }

    public char[][] landAndBasin() {
        char count = 'A';
        for (int j=0; j<array.length; j++) {
            for (int i=0; i<array[j].length; i++) {
                if (findLowestPoint(j, i).equals(getKey(j, i))) {
                    result[j][i] = count;
                    markNeighbors(j, i, count);
                    count++;
                }
            }
        }

        return result;
    }

    public void markNeighbors(int j, int i, char count) {
        String currentKey = getKey(j, i);
        if (j>0 && !Character.isLetter(result[j - 1][i]) && findLowestPoint(j-1, i).equals(currentKey)) {
            result[j-1][i] = count;
            markNeighbors(j-1, i, count);
        }
        if (j+1<array.length && !Character.isLetter(result[j + 1][i]) && findLowestPoint(j+1, i).equals(currentKey)) {
            result[j+1][i] = count;
            markNeighbors(j+1, i, count);
        }
        if (i>0 && !Character.isLetter(result[j][i - 1]) && findLowestPoint(j, i-1).equals(currentKey)) {
            result[j][i-1] = count;
            markNeighbors(j, i-1, count);
        }
        if (i+1<array[j].length && !Character.isLetter(result[j][i+1]) && findLowestPoint(j, i+1).equals(currentKey)) {
            result[j][i+1] = count;
            markNeighbors(j, i+1, count);
        }
    }

    public String findLowestPoint(int j, int i) {
        Map<Integer, String> points = new HashMap<Integer, String>();
        points.put(array[j][i], getKey(j, i));

        int base = array[j][i];
        if (j>0 && array[j-1][i] < base)
            points.put(array[j-1][i], getKey(j-1, i));
        if (j+1<array.length && array[j+1][i] < base)
            points.put(array[j+1][i], getKey(j+1, i));
        if (i>0 && array[j][i-1] < base)
            points.put(array[j][i-1], getKey(j, i-1));
        if (i+1<array[j].length && array[j][i+1] < base)
            points.put(array[j][i+1], getKey(j, i+1));

        return points.get(Collections.min(points.keySet()));
    }
}
