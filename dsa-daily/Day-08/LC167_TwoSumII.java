import java.util.*;

/**
 * Problem: Two Sum II - Input Array Is Sorted
 * Platform: LeetCode 167 (NeetCode 150)
 *
 * Approach:
 * - Use two pointers:
 *      left  → smallest value
 *      right → largest value
 *
 * - If sum is too large:
 *      move right pointer left
 *
 * - If sum is too small:
 *      move left pointer right
 *
 * - Since array is sorted, this guarantees O(n) solution
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 01-05-2026
 */

public class LC167_TwoSumII {

    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {

            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[]{left + 1, right + 1};
            }

            if (sum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new int[]{-1, -1};
    }
}