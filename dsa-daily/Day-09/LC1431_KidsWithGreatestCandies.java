import java.util.*;

/**
 * Problem: Kids With the Greatest Number of Candies
 * Platform: LeetCode 1431 (LeetCode 75)
 *
 * Approach:
 * - Find the maximum candies among all kids
 * - For each kid:
 *      check if candies[i] + extraCandies >= max
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * Author: Abhay Raj
 * Date: 11-05-2026
 */

public class LC1431_KidsWithGreatestCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {

        int maxCandies = 0;

        // Find maximum candies
        for (int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        List<Boolean> result = new ArrayList<>();

        // Check each child
        for (int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }
}