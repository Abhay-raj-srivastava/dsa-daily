import java.util.*;

/**
 * Problem: Restore IP Addresses
 * Platform: LeetCode
 *
 * Approach:
 * - Use backtracking to try all possible splits
 * - At each step:
 *      → choose 1 to 3 digits
 *      → validate segment (0–255, no leading zero)
 *      → recursively build next part
 *
 * Key Insight:
 * - Maximum 4 segments (IP format)
 * - Prune invalid paths early
 *
 * Time Complexity: O(1)  // bounded by small input size
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 16-04-2026
 */

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, 0, "", result);
        return result;
    }

    private void backtrack(String s, int index, int dots, String path, List<String> result) {

        // If 4 parts formed and string fully used
        if (dots == 4 && index == s.length()) {
            result.add(path.substring(0, path.length() - 1)); // remove last dot
            return;
        }

        // Invalid cases
        if (dots > 4) return;

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String segment = s.substring(index, index + len);

            // Skip leading zero cases
            if (segment.charAt(0) == '0' && len > 1) break;

            // Check valid range
            if (Integer.parseInt(segment) <= 255) {

                backtrack(
                        s,
                        index + len,
                        dots + 1,
                        path + segment + ".",
                        result
                );
            }
        }
    }
}