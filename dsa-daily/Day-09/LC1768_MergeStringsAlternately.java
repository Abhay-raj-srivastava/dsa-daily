import java.util.*;

/**
 * Problem: Merge Strings Alternately
 * Platform: LeetCode 1768 (LeetCode 75)
 *
 * Approach:
 * - Traverse both strings simultaneously
 * - Append characters alternately
 * - Append remaining part of longer string
 *
 * Time Complexity: O(m + n)
 * Space Complexity: O(m + n)
 *
 * Author: Abhay Raj
 * Date: 11-05-2026
 */

public class LC1768_MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int i = 0;

        StringBuilder result = new StringBuilder();

        // Merge alternately
        while (i < m && i < n) {
            result.append(word1.charAt(i));
            result.append(word2.charAt(i));
            i++;
        }

        // Append remaining characters
        if (i < m) {
            result.append(word1.substring(i));
        }

        if (i < n) {
            result.append(word2.substring(i));
        }

        return result.toString();
    }
}