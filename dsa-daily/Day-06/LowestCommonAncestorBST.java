/**
 * Problem: Lowest Common Ancestor of a Binary Search Tree
 * Platform: LeetCode (NeetCode 250)
 *
 * Approach:
 * - Use BST property:
 *      → left subtree < root < right subtree
 * - If both nodes are smaller → go left
 * - If both nodes are greater → go right
 * - Otherwise → current node is LCA
 *
 * Time Complexity: O(h)
 * Space Complexity: O(h)
 *
 * Author: Abhay Raj
 * Date: 17-04-2026
 */

public class LowestCommonAncestorBST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return null;

        // Both nodes in left subtree
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        // Both nodes in right subtree
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }

        // Split point → this is LCA
        return root;
    }
}