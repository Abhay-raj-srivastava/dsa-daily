import java.util.*;

/**
 * Problem: Balanced Positions in a Permutation
 * Platform: CodeChef Contest 235
 *
 * Approach:
 * - For each index i:
 *      Li = count of elements smaller than p[i] on left
 *      Ri = count of elements greater than p[i] on right
 * - If Li == Ri → valid position
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 23-04-2026
 */

public class CC235_BalancedPositions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] p = new int[n];

            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }

            int balancedCount = 0;

            for (int i = 0; i < n; i++) {
                int leftSmaller = 0;
                int rightGreater = 0;

                // Count smaller elements on left
                for (int j = 0; j < i; j++) {
                    if (p[j] < p[i]) leftSmaller++;
                }

                // Count greater elements on right
                for (int j = i + 1; j < n; j++) {
                    if (p[j] > p[i]) rightGreater++;
                }

                if (leftSmaller == rightGreater) {
                    balancedCount++;
                }
            }

            System.out.println(balancedCount);
        }

        sc.close();
    }
}