import java.util.Arrays;

/**
 * Problem: Find Internal Angles of a Triangle
 * Platform: Leetcode(Weekly Contest 497)
 *
 * Approach:
 * - First, validate if given sides can form a triangle
 * - Use cosine rule to calculate each angle:
 *      cos(A) = (b² + c² - a²) / (2bc)
 * - Convert radians to degrees
 * - Sort angles before returning
 *
 * Edge Case:
 * - If sides do not form a triangle → return empty array
 *
 * Example:
 * Input: [3, 4, 5]
 * Output: [36.87, 53.13, 90.0]
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 13-04-2026
 */

public class TriangleAngles {

    /**
     * Returns internal angles of triangle in sorted order
     */
    public static double[] internalAngles(int[] sides) {

        // Validate triangle
        if (!isValidTriangle(sides[0], sides[1], sides[2])) {
            return new double[0];
        }

        double[] angles = new double[3];

        // Calculate angles using cosine rule
        angles[0] = calculateAngle(sides[0], sides[1], sides[2]);
        angles[1] = calculateAngle(sides[1], sides[0], sides[2]);
        angles[2] = calculateAngle(sides[2], sides[0], sides[1]);

        // Sort angles
        Arrays.sort(angles);

        return angles;
    }

    /**
     * Checks triangle validity using triangle inequality theorem
     */
    private static boolean isValidTriangle(int a, int b, int c) {
        return (a + b > c) && (b + c > a) && (c + a > b);
    }

    /**
     * Calculates angle opposite to side 'a' using cosine rule
     */
    private static double calculateAngle(double a, double b, double c) {
        double cosA = (b * b + c * c - a * a) / (2 * b * c);

        // Handle floating point precision issues
        cosA = Math.max(-1.0, Math.min(1.0, cosA));

        return Math.toDegrees(Math.acos(cosA));
    }

    public static void main(String[] args) {
        int[] sides = {3, 4, 5};

        double[] result = internalAngles(sides);

        System.out.println("Angles:");
        for (double angle : result) {
            System.out.printf("%.2f ", angle);
        }
    }
}