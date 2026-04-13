/**
 * Problem: Count Good Subsequences After Queries
 * Platform: Leetcode(Weekly Contest 497)
 *
 * Status: TLE (Time Limit Exceeded)
 *
 * Approach:
 * - For each query:
 *      1. Update the array at given index
 *      2. Traverse entire array
 *      3. Consider only elements divisible by p
 *      4. Compute gcd of (x / p)
 *      5. Apply conditions:
 *          - If only one valid element → check if it equals p
 *          - If multiple → gcd must be 1
 *
 * Why TLE:
 * - For each query, full array traversal is done → O(n)
 * - Total complexity: O(q * n)
 * - Additional gcd computation inside loop
 * - Not scalable for large n, q (e.g., 10^5)
 *
 * Improvement Idea:
 * - Maintain dynamic structure instead of recomputing every time
 * - Use segment tree / prefix gcd / frequency tracking
 * - Avoid full traversal per query
 *
 * Note:
 * - This brute force solution is kept to document logic and understanding
 * - Will optimize using advanced data structures later
 *
 * Author: Abhay Raj
 * Date: 13-04-2026
 */

public class CountGoodSubseq {

    public static int countGoodSubseq(int[] nums, int p, int[][] queries) {
        int answer = 0;

        // Copy reference (modifying original array across queries)
        int[] arr = nums;

        for (int[] query : queries) {

            // Update array
            arr[query[0]] = query[1];

            int gcdValue = 0;
            int count = 0;

            // Traverse entire array
            for (int x : arr) {
                if (x % p == 0) {
                    gcdValue = gcd(gcdValue, x / p);
                    count++;
                }
            }

            boolean isGood = false;

            // Case 1: Only one valid element
            if (count == 1) {
                for (int x : arr) {
                    if (x == p) {
                        isGood = true;
                        break;
                    }
                }
            }

            // Case 2: Multiple elements with gcd = 1
            else if (count >= 2 && gcdValue == 1) {
                isGood = true;
            }

            if (isGood) {
                answer++;
            }
        }

        return answer;
    }

    /**
     * Computes GCD using Euclidean algorithm
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] nums = {2, 4, 6};
        int p = 2;
        int[][] queries = {
                {0, 6},
                {1, 2}
        };

        int result = countGoodSubseq(nums, p, queries);

        System.out.println("Good subsequences count: " + result);
    }
}