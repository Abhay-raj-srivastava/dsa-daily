import java.util.*;

/**
 * Problem: Hand of Straights
 * Platform: LeetCode (Neetcode)
 *
 * Approach:
 * - Use TreeMap to count frequencies (sorted order)
 * - Always start forming groups from the smallest available number
 * - For each number:
 *      → try to form a group of size 'groupSize'
 *      → reduce frequency of consecutive numbers
 *
 * Key Insight:
 * - Greedily build sequences starting from smallest element
 * - If any required number is missing → not possible
 *
 * Example:
 * Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
 * Output: true
 *
 * Time Complexity: O(n log n)
 * Space Complexity: O(n)
 *
 * Author: Abhay Raj
 * Date: 14-04-2026
 */

public class HandOfStraights {

    public static boolean isNStraightHand(int[] hand, int groupSize) {

        // If total cards not divisible → impossible
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> freq = new TreeMap<>();

        // Step 1: Count frequency
        for (int num : hand) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Form groups
        for (int start : freq.keySet()) {

            int count = freq.get(start);

            if (count > 0) {

                // Try to build group of size groupSize
                for (int i = 0; i < groupSize; i++) {
                    int current = start + i;

                    // If required number not available
                    if (freq.getOrDefault(current, 0) < count) {
                        return false;
                    }

                    // Reduce frequency
                    freq.put(current, freq.get(current) - count);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        boolean result = isNStraightHand(hand, groupSize);

        System.out.println("Can form groups: " + result);
    }
}