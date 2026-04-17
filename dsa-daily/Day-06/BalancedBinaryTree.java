/**
 * Problem: Balanced Binary Tree
 * Platform: LeetCode (NeetCode 250)
 *
 * Approach:
 * - Compute height and balance together
 * - If subtree is unbalanced → return -1 immediately
 * - Otherwise return height
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Author: Abhay Raj
 * Date: 17-04-2026
 */

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }

    /**
     * Returns height if balanced, else -1
     */
    private int checkHeight(TreeNode node) {
        if (node == null) return 0;

        int left = checkHeight(node.left);
        if (left == -1) return -1;

        int right = checkHeight(node.right);
        if (right == -1) return -1;

        // Check balance condition
        if (Math.abs(left - right) > 1) return -1;

        return Math.max(left, right) + 1;
    }
}