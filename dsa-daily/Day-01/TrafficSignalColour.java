/**
 * Problem: Traffic Signal State Based on Timer
 * Platform: Custom / Practice
 *
 * Approach:
 * - Direct conditional mapping based on timer value
 * - Timer = 0      → Green (start signal)
 * - Timer = 30     → Orange (transition warning)
 * - Timer (31–90)  → Red (stop signal)
 * - Any other value → Invalid input
 *
 * Example:
 * Input: timer = 45
 * Output: "Red"
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 12-04-2026
 */

class TrafficSignalColour {

    public String trafficSignal(int timer) {
        if (timer == 0) return "Green";
        else if (timer == 30) return "Orange";
        else if (timer > 30 && timer <= 90) return "Red";
        else return "Invalid";
    }

    public static void main(String[] args) {
        TrafficSignalColour obj = new TrafficSignalColour();

        int timer = 45;
        String result = obj.trafficSignal(timer);

        System.out.println(result);
    }
}