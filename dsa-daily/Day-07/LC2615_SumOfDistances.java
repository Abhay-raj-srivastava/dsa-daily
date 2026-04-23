import java.util.*;

/**
 * Problem: Sum of Distances
 * Platform: LeetCode 2615
 *
 * Status: TLE (Time Limit Exceeded)
 *
 * Approach:
 * - Group indices by value using HashMap
 * - For each index, iterate over all indices with same value
 * - Compute sum of absolute differences
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * Reason for TLE:
 * - For each index, we iterate through all same-value indices
 * - Leads to quadratic time in worst case
 *
 * Optimization Idea:
 * - Use prefix sums on indices to compute distances efficiently
 * - Reduce time complexity to O(n)
 *
 * Author: Abhay Raj
 * Date: 23-04-2026
 */

public class LC2615_SumOfDistances {

    public long[] distance(int[] nums) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[] res = new long[n];

        // Group indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Compute distances
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.get(nums[i]);

            long sum = 0;
            for (int idx : list) {
                if (idx != i) {
                    sum += Math.abs((long) i - idx);
                }
            }
            res[i] = sum;
        }

        return res;
    }
}