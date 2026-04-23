import java.util.*;

/**
 * Problem: Score Check
 * Platform: CodeChef Contest 235
 *
 * Approach:
 * - If y > x → print 100
 * - Else → print 0
 *
 * Author: Abhay Raj
 * Date: 23-04-2026
 */


public class CC235_ContestRegistrationFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println(y > x ? 100 : 0);

        sc.close();
    }
}