import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by uarem on 4/27/2015.
 *
 * https://leetcode.com/problems/3sum-closest/
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 */
public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        List<Integer> totalSum = new ArrayList<Integer>();
        int maxDiff = Integer.MAX_VALUE, holder = 0;
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {
            int j = i+1, k = nums.length-1;

            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];

                    if (!totalSum.contains(sum)) totalSum.add(sum);

                    int diff = Math.abs(sum-target);
                    if (diff == 0) {
                        return sum;
                    } else {
                        if (maxDiff > diff) {
                            maxDiff = diff;
                            holder = sum;
                        }

                        if (sum > target)
                            k--;
                        else
                            j++;
                    }
                }
            }
        }
        return holder;
    }
}
