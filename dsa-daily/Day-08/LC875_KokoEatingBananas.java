import java.util.*;

/**
 * Problem: Koko Eating Bananas
 * Platform: LeetCode 875
 *
 * Approach:
 * - Binary search on eating speed (k)
 * - Search space:
 *      min = 1
 *      max = max pile size
 *
 * - For each k:
 *      calculate total hours needed
 *      using ceiling division
 *
 * Time Complexity: O(n log max(pile))
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 01-05-2026
 */

public class LC875_KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find max pile
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            long hoursNeeded = 0;

            for (int pile : piles) {
                hoursNeeded += (pile + mid - 1) / mid; // ceil division

                if (hoursNeeded > h) break;
            }

            if (hoursNeeded <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}