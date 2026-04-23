import java.util.*;

/**
 * Problem: Recover Palindrome (Uniqueness Check)
 * Platform: CodeChef Contest 235
 *
 * Approach:
 * - Use two pointers (i, j)
 * - Compare characters from both ends
 * - If both are '?' → multiple possibilities → not unique
 * - Otherwise continue
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 23-04-2026
 */

public class CC235_RecoverPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            int left = 0, right = n - 1;
            boolean isUnique = true;

            while (left <= right) {

                // If both sides are '?', multiple valid choices exist
                if (s.charAt(left) == '?' && s.charAt(right) == '?') {
                    isUnique = false;
                    break;
                }

                left++;
                right--;
            }

            System.out.println(isUnique ? "YES" : "NO");
        }

        sc.close();
    }
}