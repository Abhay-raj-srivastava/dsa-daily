import java.io.*;
import java.util.*;

/**
 * Problem: MEX Spectrum
 * Platform: CodeChef Contest 235
 *
 * Approach:
 * - Count frequency of values (only up to n)
 * - Track how many distinct values from [0...k-1] are present
 * - For each k:
 *      gaps = k - distinctSeen
 *      obstacles = freq[k]
 * - Answer = max(gaps, obstacles)
 *
 * Key Insight:
 * - Missing values (gaps) and extra occurrences (obstacles) determine operations
 *
 * Time Complexity: O(n) per test case
 * Space Complexity: O(n)
 *
 * Author: Abhay Raj
 * Date: 23-04-2026
 */

public class CC235_MEXSpectrum {

    public static void main(String[] args) throws IOException {
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(System.out);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] freq = new int[n + 1];

            // Frequency counting
            for (int i = 0; i < n; i++) {
                int val = sc.nextInt();
                if (val <= n) {
                    freq[val]++;
                }
            }

            int distinctSeen = 0;
            StringBuilder result = new StringBuilder();

            for (int k = 0; k <= n; k++) {

                int gaps = k - distinctSeen;   // missing numbers in [0...k-1]
                int obstacles = freq[k];       // occurrences of k

                result.append(Math.max(gaps, obstacles)).append(" ");

                if (freq[k] > 0) {
                    distinctSeen++;
                }
            }

            out.println(result.toString().trim());
        }

        out.flush();
        out.close();
    }

    // Fast I/O
    static class FastReader {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreElements()) {
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}