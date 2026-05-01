import java.util.*;

/**
 * Problem: 3Sum
 * Platform: LeetCode 15 (NeetCode 150)
 *
 * Approach:
 * - Sort the array
 * - Fix one element nums[i]
 * - Use two pointers to find remaining two numbers
 *
 * Duplicate Handling:
 * - Skip duplicate values for i
 * - Skip duplicate values for left and right pointers
 *
 * Time Complexity: O(n^2)
 * Space Complexity: O(1) excluding output
 *
 * Author: Abhay Raj
 * Date: 01-05-2026
 */

public class LC15_ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {

            // Skip duplicate starting values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(
                            nums[i],
                            nums[left],
                            nums[right]
                    ));

                    // Skip duplicate left values
                    while (left < right &&
                            nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate right values
                    while (left < right &&
                            nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                }

                else if (sum < 0) {
                    left++;
                }

                else {
                    right--;
                }
            }
        }

        return result;
    }
}