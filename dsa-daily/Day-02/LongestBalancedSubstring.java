/**
 * Problem: Longest Balanced Substring
 * Platform: Leetcode(Weekly Contest 497)
 *
 * Status: TLE (Time Limit Exceeded)
 *
 * Approach:
 * - Consider all substrings using two loops
 * - Count number of '0's and '1's in each substring
 * - Check:
 *      1. Perfect balance → zeros == ones
 *      2. Near balance (difference = 2) with possibility of adjustment
 * - Track maximum valid length
 *
 * Why TLE:
 * - Using nested loops → O(n^2)
 * - For each substring, counting is done incrementally
 * - Not efficient for large strings (n up to 10^5)
 *
 * Improvement Idea:
 * - Use prefix sum or difference tracking (0 → -1, 1 → +1)
 * - Use HashMap to store first occurrence of prefix sum
 * - Reduce to O(n)
 *
 * Note:
 * - This brute force approach is kept to document reasoning
 * - Will optimize using prefix sum in future
 *
 * Author: Abhay Raj
 * Date: 13-04-2026
 */

public class LongestBalancedSubstring {

    public static int longestBalanced(String s) {
        int n = s.length();
        int maxLength = 0;

        // Count total zeros and ones (used for relaxed condition)
        int totalZeros = 0, totalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') totalZeros++;
            else totalOnes++;
        }

        // Try all substrings
        for (int i = 0; i < n; i++) {
            int zeros = 0, ones = 0;

            for (int j = i; j < n; j++) {

                if (s.charAt(j) == '0') zeros++;
                else ones++;

                // Perfectly balanced substring
                if (zeros == ones) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }

                // Near-balanced case (difference = 2)
                else if (Math.abs(zeros - ones) == 2) {

                    // Check if extra characters exist outside substring
                    if (zeros > ones && totalOnes > ones) {
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                    else if (ones > zeros && totalZeros > zeros) {
                        maxLength = Math.max(maxLength, j - i + 1);
                    }
                }
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String s = "010110";

        int result = longestBalanced(s);

        System.out.println("Longest Balanced Length: " + result);
    }
}