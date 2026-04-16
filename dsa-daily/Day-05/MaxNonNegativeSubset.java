import java.util.*;

/**
 * Problem: Maximize Count with Non-negative Sum (CodeChef Contest)
 * Platform: CodeChef
 *
 * Approach:
 * - Sort the array
 * - Start from largest elements (greedy choice)
 * - Keep adding elements to maintain non-negative sum
 * - Include negative elements only if total sum stays >= 0
 *
 * Key Insight:
 * - Always take largest values first
 * - Add negative values only if they don’t break the sum
 *
 * Time Complexity: O(n log n)  // sorting
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 16-04-2026
 */

public class MaxNonNegativeSubset {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            Arrays.sort(arr);

            int count = 0;
            int sum = 0;

            // Traverse from largest to smallest
            for (int i = n - 1; i >= 0; i--) {

                // Always take positive numbers
                if (arr[i] >= 0) {
                    sum += arr[i];
                    count++;
                }
                // Take negative only if sum remains non-negative
                else if (sum + arr[i] >= 0) {
                    sum += arr[i];
                    count++;
                }
            }

            System.out.println(count);
        }

        sc.close();
    }
}