import java.util.*;

/**
 * Problem: Binary Tree Inorder Traversal
 * Platform: LeetCode
 *
 * Approach:
 * - Use recursion:
 *      1. Traverse left subtree
 *      2. Visit current node
 *      3. Traverse right subtree
 *
 * Key Insight:
 * - Inorder traversal of BST gives sorted order
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // recursion stack
 *
 * Author: Abhay Raj
 * Date: 15-04-2026
 */

public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    /**
     * Helper method for recursion
     */
    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        inorder(node.left, result);   // Left
        result.add(node.val);         // Root
        inorder(node.right, result);  // Right
    }
}

/*  Iterative Approach

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
    }

    return result;
}
*/