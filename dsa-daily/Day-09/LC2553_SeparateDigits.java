import java.util.*;

/**
 * Problem: Separate the Digits in an Array
 * Platform: LeetCode 2553
 *
 * Approach:
 * - Extract digits for each number
 * - Store digits in correct order
 * - Use temporary list + reverse
 *
 * Time Complexity: O(total digits)
 * Space Complexity: O(total digits)
 *
 * Author: Abhay Raj
 * Date: 11-05-2026
 */

public class LC2553_SeparateDigits {

    public int[] separateDigits(int[] nums) {

        List<Integer> result = new ArrayList<>();

        for (int num : nums) {

            // Handle zero separately
            if (num == 0) {
                result.add(0);
                continue;
            }

            List<Integer> digits = new ArrayList<>();

            // Extract digits in reverse order
            while (num > 0) {
                digits.add(num % 10);
                num /= 10;
            }

            // Reverse to restore original order
            Collections.reverse(digits);

            result.addAll(digits);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}