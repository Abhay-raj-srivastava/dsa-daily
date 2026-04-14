/**
 * Problem: Jump Game II
 * Platform: LeetCode (NeetCode 150)
 *
 * Approach:
 * - Use greedy + BFS-like range expansion
 * - Maintain a window [l, r] representing current reachable range
 * - For all indices in this range:
 *      → find the farthest reachable index
 * - Move to next range and increment jumps
 *
 * Key Insight:
 * - Each iteration represents one "jump level"
 * - We expand the reachable boundary greedily
 *
 * Example:
 * Input: [2,3,1,1,4]
 * Output: 2
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 14-04-2026
 */

public class JumpGameII {

    public static int jump(int[] nums) {
        int n = nums.length;

        int left = 0, right = 0;
        int jumps = 0;

        // Continue until we reach the last index
        while (right < n - 1) {

            int farthest = 0;

            // Explore current window
            for (int i = left; i <= right; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }

            // Move to next window
            left = right + 1;
            right = farthest;

            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        int result = jump(nums);

        System.out.println("Minimum jumps: " + result);
    }
}