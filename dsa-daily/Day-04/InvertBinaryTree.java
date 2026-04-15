/**
 * Problem: Invert Binary Tree
 * Platform: LeetCode
 *
 * Approach:
 * - Recursively swap left and right children
 * - Do this for every node in the tree
 *
 * Key Insight:
 * - Each node independently swaps its children
 * - This creates a mirror image of the tree
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // recursion stack
 *
 * Author: Abhay Raj
 * Date: 15-04-2026
 */

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        // Swap left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

/*  Iterative Approach

public TreeNode invertTree(TreeNode root) {
    if (root == null) return null;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();

        // Swap children
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }

    return root;
}
*/