import java.util.*;

/**
 * Problem: Binary Tree Postorder Traversal
 * Platform: LeetCode
 *
 * Approach:
 * - Traverse in order:
 *      1. Left subtree
 *      2. Right subtree
 *      3. Visit root
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)  // recursion stack
 *
 * Author: Abhay Raj
 * Date: 15-04-2026
 */

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    /**
     * Helper function for recursion
     */
    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) return;

        postorder(node.left, result);   // Left
        postorder(node.right, result);  // Right
        result.add(node.val);           // Root
    }
}

/*  Iterative Approach

public List<Integer> postorderTraversal(TreeNode root) {
    LinkedList<Integer> result = new LinkedList<>();
    if (root == null) return result;

    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);

    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.addFirst(node.val);

        if (node.left != null) stack.push(node.left);
        if (node.right != null) stack.push(node.right);
    }

    return result;
}
*/