import java.util.*;

/**
 * Problem: Binary Tree Preorder Traversal
 * Platform: LeetCode
 *
 * Approach:
 * - Traverse in order:
 *      1. Visit root
 *      2. Traverse left subtree
 *      3. Traverse right subtree
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // recursion stack
 *
 * Author: Abhay Raj
 * Date: 15-04-2026
 */

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    /**
     * Helper function for recursion
     */
    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);        // Root
        preorder(node.left, result); // Left
        preorder(node.right, result);// Right
    }
}

/*  Iterative Approach

public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);

        // Push right first (so left is processed first)
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }

    return result;
}
*/