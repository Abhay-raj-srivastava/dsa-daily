/**
 * Problem: Maximum Depth of Binary Tree
 * Platform: LeetCode
 *
 * Approach:
 * - Recursively compute depth of left and right subtree
 * - Depth of node = 1 + max(leftDepth, rightDepth)
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // recursion stack
 *
 * Author: Abhay Raj
 * Date: 15-04-2026
 */

public class MaxDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}

/*  Iterative Approach

public int maxDepth(TreeNode root) {
    if (root == null) return 0;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);

    int depth = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();

        for (int i = 0; i < size; i++) {
            TreeNode node = queue.poll();

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }

        depth++;
    }

    return depth;
}
 */