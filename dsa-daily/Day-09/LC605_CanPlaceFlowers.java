import java.util.*;

/**
 * Problem: Can Place Flowers
 * Platform: LeetCode 605 (LeetCode 75)
 *
 * Approach:
 * - Traverse the flowerbed greedily
 * - If current position already has a flower:
 *      skip next position
 *
 * - Otherwise:
 *      place flower if next position is empty
 *      (previous position safety is handled implicitly
 *       by traversal and skipping logic)
 *
 * Greedy Insight:
 * - After encountering or placing a flower,
 *   adjacent positions become invalid,
 *   so we skip them directly.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 11-05-2026
 */

public class LC605_CanPlaceFlowers {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {

            // Existing flower → skip adjacent plot
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }

            // Check if right side is safe
            boolean rightEmpty =
                    (i == length - 1 || flowerbed[i + 1] == 0);

            // Place flower greedily
            if (rightEmpty) {
                n--;
                i++; // skip adjacent position
            }

            // Early exit
            if (n <= 0) {
                return true;
            }
        }

        return n <= 0;
    }
}