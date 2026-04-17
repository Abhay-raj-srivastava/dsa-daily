/**
 * Problem: Same Tree
 * Platform: LeetCode (NeetCode 250)
 *
 * Approach:
 * - Compare both nodes:
 *      1. If both are null → true
 *      2. If one is null → false
 *      3. If values differ → false
 *      4. Recursively compare left and right subtrees
 *
 * Time Complexity: O(n)
 * Space Complexity: O(h)
 *
 * Author: Abhay Raj
 * Date: 17-04-2026
 */

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Case 1: both null
        if (p == null && q == null) return true;

        // Case 2: one null
        if (p == null || q == null) return false;

        // Case 3: values differ
        if (p.val != q.val) return false;

        // Case 4: check subtrees
        return isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}