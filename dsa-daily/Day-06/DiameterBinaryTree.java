/**
 * Problem: Diameter of Binary Tree
 * Platform: LeetCode (NeetCode 250)
 *
 * Approach:
 * - Compute height while updating diameter
 * - At each node:
 *      diameter = leftHeight + rightHeight
 * - Track maximum diameter globally
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Author: Abhay Raj
 * Date: 17-04-2026
 */

public class DiameterBinaryTree {

    private int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    /**
     * Returns height while updating diameter
     */
    private int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        int right = height(node.right);

        // Update diameter
        diameter = Math.max(diameter, left + right);

        return Math.max(left, right) + 1;
    }
}