import java.util.*;

/**
 * Problem: Binary String Construction (CodeChef Contest)
 * Platform: CodeChef
 *
 * Approach:
 * - For each test case:
 *      n = length of required binary string
 *
 * - Handle small cases separately:
 *      n = 2 → "01"
 *      n = 3 → "001"
 *
 * - For n >= 4:
 *      → Start with '0'
 *      → Fill middle with (n - 2) ones
 *      → End with '0'
 *
 * Time Complexity: O(n) per test case
 * Space Complexity: O(n)
 *
 * Author: Abhay Raj
 * Date: 16-04-2026
 */

public class BinaryStringConstruction {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            StringBuilder result = new StringBuilder();

            if (n == 2) {
                result.append("01");
            }
            else if (n == 3) {
                result.append("001");
            }
            else {
                result.append("0");

                // Fill middle with '1's
                for (int i = 0; i < n - 2; i++) {
                    result.append("1");
                }

                result.append("0");
            }

            System.out.println(result.toString());
        }

        sc.close();
    }
}