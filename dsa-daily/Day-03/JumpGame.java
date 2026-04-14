/**
 * Problem: Jump Game
 * Platform: LeetCode (NeetCode 150)
 *
 * Approach:
 * - Work backwards from the last index (goal)
 * - Check if current index can reach the goal
 * - If yes → update goal to current index
 * - At the end, check if goal becomes 0
 *
 * Key Insight:
 * - Instead of checking forward jumps, track the last reachable position
 * - Reduce the problem to: "Can I reach the goal from index 0?"
 *
 * Example:
 * Input: [2,3,1,1,4]
 * Output: true
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 14-04-2026
 */

public class JumpGame {

    public static boolean canJump(int[] nums) {
        int n = nums.length;

        // Start from last index
        int goal = n - 1;

        // Traverse backwards
        for (int i = n - 2; i >= 0; i--) {

            // If current index can reach the goal
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }

        // If we can reach index 0, answer is true
        return goal == 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};

        boolean result = canJump(nums);

        System.out.println("Can reach end: " + result);
    }
}