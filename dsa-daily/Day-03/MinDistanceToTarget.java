/**
 * Problem: Minimum Distance to the Target Element
 * Platform: LeetCode (Daily)
 *
 * Approach:
 * - Traverse the array
 * - For every occurrence of target:
 *      → compute distance from start index
 *      → keep track of minimum distance
 *
 * Key Insight:
 * - We only care about indices where nums[i] == target
 * - Among those, pick the closest to 'start'
 *
 * Example:
 * Input: nums = [1,2,3,4,5], target = 5, start = 3
 * Output: 1
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 14-04-2026
 */

public class MinDistanceToTarget {

    public static int getMinDistance(int[] nums, int target, int start) {
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            // Check only target positions
            if (nums[i] == target) {

                int distance = Math.abs(i - start);

                // Update minimum distance
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 5;
        int start = 3;

        int result = getMinDistance(nums, target, start);

        System.out.println("Minimum Distance: " + result);
    }
}