/**
 * Problem: Count Digit Occurrences in Array
 * Platform: Practice / LeetCode-style
 *
 * Approach:
 * - Traverse each number in the array
 * - Extract digits using modulo (%) and division (/)
 * - Count how many times the target digit appears
 *
 * Edge Case:
 * - If number = 0 and digit = 0 → count it once
 *
 * Example:
 * Input: nums = [10, 20, 33], digit = 0
 * Output: 2
 *
 * Time Complexity: O(n * d)
 *   where d = number of digits in each number
 *
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 12-04-2026
 */

public class CountDigitOccurrences {

    /**
     * Counts occurrences of a digit in all numbers of the array
     *
     * @param nums  Array of integers
     * @param digit Target digit (0–9)
     * @return Total occurrences
     */
    public static int countDigitOccurrences(int[] nums, int digit) {
        int count = 0;

        for (int num : nums) {

            // Special case: number is 0
            if (num == 0 && digit == 0) {
                count++;
                continue;
            }

            // Extract digits one by one
            while (num > 0) {
                int lastDigit = num % 10;

                if (lastDigit == digit) {
                    count++;
                }

                num /= 10;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {10, 20, 33};
        int digit = 0;

        int result = countDigitOccurrences(nums, digit);

        System.out.println("Total occurrences: " + result);
    }
}