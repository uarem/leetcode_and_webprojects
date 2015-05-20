import java.util.*;

/**
 * Created by uarem on 4/27/2015.
 *
 * https://leetcode.com/problems/3sum/
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 */
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(num);

        for (int i=0; i<num.length-2; i++) {
            int j = i + 1;
            int k = num.length - 1;


            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {
                while (j < k) {
                    int sum = num[i] + num[j] + num[k];
                    if (sum == 0) {
                        List<Integer> newItem = new ArrayList<Integer>();
                        newItem.addAll(Arrays.asList(num[i], num[j], num[k]));
                        result.add(newItem);
                        while (j < k && num[j] == num[j + 1]) j++;
                        while (j < k && num[k] == num[k - 1]) k--;
                        j++;
                        k--;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }
}