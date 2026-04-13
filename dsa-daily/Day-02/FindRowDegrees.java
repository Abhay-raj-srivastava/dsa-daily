/**
 * Problem: Find Row Degrees (Sum of each row in matrix)
 * Platform: Leetcode(Weekly Contest 497)
 *
 * Approach:
 * - Traverse each row of the matrix
 * - Sum all elements in that row
 * - Store result in output array
 *
 * Example:
 * Input:
 * [
 *   [1, 2, 3],
 *   [0, 1, 0],
 *   [4, 5, 6]
 * ]
 * Output: [6, 1, 15]
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 *
 * Author: Abhay Raj
 * Date: 13-04-2026
 */

public class FindRowDegrees {

    /**
     * Returns sum of each row in matrix
     */
    public static int[] findDegrees(int[][] matrix) {
        int n = matrix.length;
        int[] degrees = new int[n];

        for (int i = 0; i < n; i++) {
            int rowSum = 0;

            // Sum all elements in current row
            for (int j = 0; j < matrix[i].length; j++) {
                rowSum += matrix[i][j];
            }

            degrees[i] = rowSum;
        }

        return degrees;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {0, 1, 0},
                {4, 5, 6}
        };

        int[] result = findDegrees(matrix);

        System.out.println("Row sums:");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}