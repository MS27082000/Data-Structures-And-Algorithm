/** Minimum Number of Insertions and Deletions to convert string A to string B (Delete Operation for Two Strings is the deletions-only version, LC 583) */
public class MinimumInsertionsDeletionsAToB {

    // Keep their LCS untouched. Everything in A outside the LCS must be deleted (m - lcs); everything in B outside the LCS must be inserted
    // (n - lcs). Total = m + n - 2 * lcs. O(m*n) time, O(n) space
    static int minOperations(String a, String b) {
        int m = a.length(), n = b.length();
        int[] prev = new int[n + 1], cur = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                cur[j] = a.charAt(i - 1) == b.charAt(j - 1) ? 1 + prev[j - 1] : Math.max(prev[j], cur[j - 1]);
            }
            int[] tmp = prev; prev = cur; cur = tmp;
        }
        return m + n - 2 * prev[n];
    }

    public static void main(String[] args) {
        System.out.println(minOperations("heap", "pea"));        // 3  (delete h, p; insert p... LCS "ea": 2 deletes + 1 insert)
        System.out.println(minOperations("abc", "abc"));         // 0
        System.out.println(minOperations("abc", "def"));         // 6
        System.out.println(minOperations("sea", "eat"));         // 2  (delete s, insert t)
        System.out.println(minOperations("", "abc"));            // 3
    }
}
