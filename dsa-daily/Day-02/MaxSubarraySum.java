/**
 * Problem: Maximum Subarray Sum
 * Platform: LeetCode (Neetcode 150)
 *
 * Approach:
 * - Use Kadane’s Algorithm
 * - Keep a running sum of subarray
 * - If sum becomes negative, reset it to 0
 * - Track maximum sum encountered
 *
 * Key Insight:
 * - A negative prefix will only reduce future subarray sums
 * - So we discard it and start fresh
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: Subarray [4,-1,2,1] gives maximum sum
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj Srivastava
 * Date: 13-04-2026
 */

public class MaxSubarraySum {

    /**
     * Finds maximum subarray sum using Kadane's Algorithm
     */
    public static int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // If current sum becomes negative, discard it
            if (currentSum < 0) {
                currentSum = 0;
            }

            currentSum += nums[i];

            // Update maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }
}
