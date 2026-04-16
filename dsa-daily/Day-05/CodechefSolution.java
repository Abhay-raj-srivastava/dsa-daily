import java.util.*;

/**
 * Problem: Score Calculation (CodeChef Contest)
 * Platform: CodeChef
 *
 * Approach:
 * - Each problem gives:
 *      → 60 points normally
 *      → k bonus points
 * - But maximum allowed per problem = 100
 *
 * - Total score = min(60 * n + k, 100 * n)
 *
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 *
 * Author: Abhay Raj
 * Date: 16-04-2026
 */

public class CodechefSolution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // number of problems
        int k = sc.nextInt(); // bonus points

        int result = Math.min(60 * n + k, 100 * n);

        System.out.println(result);

        sc.close(); // good practice
    }
}