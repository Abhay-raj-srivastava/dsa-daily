/**
 * Problem: Minimum Operations to Alternate Prime and Non-Prime
 * Platform: Practice / LeetCode-style
 *
 * Approach:
 * - Traverse the array
 * - For even indices → ensure element is PRIME
 * - For odd indices  → ensure element is NON-PRIME
 * - Increment element until condition is satisfied
 * - Count total increments (operations)
 *
 * Key Insight:
 * - We greedily fix each position independently
 * - Since only increment is allowed, we move forward until condition matches
 *
 * Example:
 * Input:  [4, 3, 6]
 * Output: 2
 * Explanation:
 * - Index 0 → 4 → 5 (prime) → 1 operation
 * - Index 1 → 3 → 4 (non-prime) → 1 operation
 *
 * Time Complexity: O(n * sqrt(k))  
 *   where k = max value after increments
 *
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 12-04-2026
 */

public class MinOperationsAlternatePrime {

    /**
     * Computes minimum operations to make array alternate
     * between prime (even index) and non-prime (odd index)
     */
    public static int minOperations(int[] nums) {
        int operations = 0;

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];

            // Even index → should be PRIME
            if (i % 2 == 0) {
                while (!isPrime(value)) {
                    value++;
                    operations++;
                }
            }
            // Odd index → should be NON-PRIME
            else {
                while (isPrime(value)) {
                    value++;
                    operations++;
                }
            }
        }

        return operations;
    }

    /**
     * Checks if a number is prime
     */
    private static boolean isPrime(int n) {
        // Edge case: numbers <= 1 are not prime
        if (n <= 1) return false;

        // Check divisibility up to sqrt(n)
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6};

        int result = minOperations(nums);

        System.out.println("Minimum operations: " + result);
    }
}