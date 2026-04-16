import java.util.*;

/**
 * Problem: Sum Calculation (CodeChef Contest)
 * Platform: CodeChef
 *
 * Approach:
 * - Given n and m
 *
 * - Special case:
 *      If n = m + 1 → answer = n
 *
 * - Otherwise:
 *      Use formula:
 *      result = ((n - m) * (n + m + 1)) / 2
 *
 *      → derived from sum of arithmetic sequence
 *
 * Time Complexity: O(1) per test case
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 16-04-2026
 */

public class SumCalculation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == m + 1) {
                System.out.println(n);
                continue;
            }

            int result = ((n - m) * (n + m + 1)) / 2;

            System.out.println(result);
        }

        sc.close();
    }
}
