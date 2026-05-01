import java.util.*;

/**
 * Problem: Container With Most Water
 * Platform: LeetCode 11
 *
 * Approach:
 * - Use two pointers (left, right)
 * - Area = min(height[left], height[right]) * width
 * - Move pointer with smaller height
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 01-05-2026
 */

public class LC11_ContainerWithMostWater {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            int width = right - left;

            maxArea = Math.max(maxArea, h * width);

            // Move the smaller pointer
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}