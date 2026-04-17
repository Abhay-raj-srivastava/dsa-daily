/**
 * Problem: Subtree of Another Tree
 * Platform: LeetCode (NeetCode 250)
 *
 * Approach:
 * - Traverse the main tree
 * - At each node:
 *      → check if subtree rooted here matches subRoot
 * - Use helper function to compare trees
 *
 * Time Complexity: O(n * m)
 * Space Complexity: O(h)
 *
 * Author: Abhay Raj
 * Date: 17-04-2026
 */

public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;

        // Check if current subtree matches
        if (isSame(root, subRoot)) return true;

        // Otherwise check left or right subtree
        return isSubtree(root.left, subRoot) ||
                isSubtree(root.right, subRoot);
    }

    /**
     * Helper: checks if two trees are identical
     */
    private boolean isSame(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.val != b.val) return false;

        return isSame(a.left, b.left) &&
                isSame(a.right, b.right);
    }
}