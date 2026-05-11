import java.util.*;

/**
 * Problem: Greatest Common Divisor of Strings
 * Platform: LeetCode 1071 (LeetCode 75)
 *
 * Approach:
 * - Two strings can have a common divisor only if:
 *      str1 + str2 == str2 + str1
 *
 * - The length of the answer will be:
 *      gcd(length1, length2)
 *
 * - Return prefix of gcd length
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n)
 *
 * Author: Abhay Raj
 * Date: 11-05-2026
 */

public class LC1071_GCDOfStrings {

    public String gcdOfStrings(String str1, String str2) {

        // Check if strings are compatible
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        int gcdLength = gcd(str1.length(), str2.length());

        return str1.substring(0, gcdLength);
    }

    /**
     * Euclidean Algorithm for GCD
     */
    private int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }
}