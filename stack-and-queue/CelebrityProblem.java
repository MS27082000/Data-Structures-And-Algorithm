/** The Celebrity Problem: M[i][j] == 1 means person i knows person j. A celebrity is known by everyone and knows nobody.
 *  Return the celebrity's index, or -1 if there is none. */
public class CelebrityProblem {

    // Two pointers eliminate one candidate per comparison: if a knows b then a is NOT a celebrity, else b is NOT.
    // Then verify the survivor. O(n) time, O(1) space (O(n^2) would be the brute force)
    static int celebrity(int[][] m) {
        int n = m.length;
        int a = 0, b = n - 1;
        while (a < b) {
            if (m[a][b] == 1) a++;            // a knows b => a can't be the celebrity
            else b--;                         // a doesn't know b => b can't be the celebrity
        }
        int candidate = a;
        for (int i = 0; i < n; i++) {         // verification: knows nobody, known by everybody else
            if (i == candidate) continue;
            if (m[candidate][i] == 1 || m[i][candidate] == 0) return -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        System.out.println(celebrity(new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 1, 0}}));          // 1
        System.out.println(celebrity(new int[][]{{0, 1}, {1, 0}}));                            // -1 (they know each other)
        System.out.println(celebrity(new int[][]{{0}}));                                       // 0 (alone: trivially a celebrity)
        System.out.println(celebrity(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));           // -1 (nobody is known)
        System.out.println(celebrity(new int[][]{{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}, {0, 1, 1, 0}})); // 2
    }
}
