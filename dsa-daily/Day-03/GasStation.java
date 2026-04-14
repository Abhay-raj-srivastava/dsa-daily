/**
 * Problem: Gas Station
 * Platform: LeetCode (NeetCode 150)
 *
 * Approach:
 * - Track total gas surplus to check if solution exists
 * - Maintain current surplus while traversing stations
 * - If current surplus becomes negative:
 *      → current start is invalid
 *      → reset and try next station
 *
 * Key Insight:
 * - If total gas < total cost → impossible
 * - If a segment fails, none of its indices can be a valid start
 *
 * Example:
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 14-04-2026
 */

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalSurplus = 0;    // Overall feasibility check
        int currentSurplus = 0;  // Current tank balance
        int startStation = 0;    // Candidate starting index

        for (int i = 0; i < gas.length; i++) {

            int diff = gas[i] - cost[i];

            totalSurplus += diff;
            currentSurplus += diff;

            // If tank becomes negative, reset start
            if (currentSurplus < 0) {
                currentSurplus = 0;
                startStation = i + 1;
            }
        }

        // If total gas is insufficient, no solution exists
        return (totalSurplus < 0) ? -1 : startStation;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int result = canCompleteCircuit(gas, cost);

        System.out.println("Starting Station: " + result);
    }
}