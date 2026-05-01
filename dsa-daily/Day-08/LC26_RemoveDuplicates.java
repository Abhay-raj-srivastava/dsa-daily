import java.util.*;

/**
 * Problem: Remove Duplicates from Sorted Array
 * Platform: LeetCode 26
 *
 * Approach:
 * - Use two pointers:
 *      i → last unique element
 *      j → current scanning pointer
 *
 * - If nums[j] != nums[i]:
 *      move i forward and overwrite nums[i]
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 01-05-2026
 */

public class LC26_RemoveDuplicates {

    public int removeDuplicates(int[] nums) {

        int i = 0; // pointer for unique elements

        for (int j = 1; j < nums.length; j++) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}