import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by uarem on 3/7/2015.
 *
 * http://www.yodlecareers.com/puzzles/triangle.html
 */
public class Yodle {
    List<List<Integer>> buffer;
    Map<String, Integer> map;

    public Yodle() {
        buffer = new ArrayList<List<Integer>>();
        map = new HashMap<String, Integer>();
    }

    private void readFile() {
        File file = new File("triangle.txt");
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(reader);
            String line;

            while ((line = bReader.readLine()) != null) {
                List<Integer> newArray = new ArrayList<Integer>();
                String[] splits = line.split("\\s+");
                for (int i = 0; i < splits.length; i++) {
                    newArray.add(Integer.parseInt(splits[i]));
                }
                buffer.add(newArray);
            }

            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void triangle() {
        long startTime = System.currentTimeMillis();
        readFile();

        System.out.println("Total sum: " + getMaxSum(0, 0));
        long stopTime = System.currentTimeMillis();
        long elapsedTime = stopTime - startTime;
        System.out.println("Total Execution Time: " + elapsedTime);
    }

    private int getMaxSum(int verticalIndex, int horizontalIndex) {
        String hashKey = new StringBuilder().append(verticalIndex).append(",")
                .append(horizontalIndex).toString();
        if (map.containsKey(hashKey))
            return map.get(hashKey);

        int leftSum = (buffer.size() > verticalIndex + 1) ? getMaxSum(
                verticalIndex + 1, horizontalIndex) : 0;
        int rightSum = (buffer.size() > verticalIndex + 1) ? getMaxSum(
                verticalIndex + 1, horizontalIndex + 1) : 0;
        int maxSum = buffer.get(verticalIndex).get(horizontalIndex)
                + (leftSum > rightSum ? leftSum : rightSum);

        map.putIfAbsent(hashKey, maxSum);
        return maxSum;
    }
}