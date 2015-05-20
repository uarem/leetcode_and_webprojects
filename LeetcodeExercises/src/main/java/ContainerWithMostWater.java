/**
 * Created by uarem on 5/11/2015.
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxSpace = 0, i=0, j=height.length-1;

        while (i<j) {
            int space = (j-i) * Math.min(height[i], height[j]);
            maxSpace = Math.max(space, maxSpace);

            if (height[i]<=height[j]) {
                do {
                    i++;
                } while (i<j && height[i-1] >= height[i]);
            } else {
                do {
                    j--;
                } while (i<j && height[j+1] >= height[j]);
            }
        }
        return maxSpace;
    }
}
