/** Minimum Insertions to Make a String Palindrome (LC 1312) - also: minimum DELETIONS to make it a palindrome (same number) */
public class MinimumInsertionsToMakePalindrome {

    // Keep the longest palindromic subsequence; every other character needs a mirror partner inserted. Answer = n - LPS.
    // O(n^2) time, O(n) space
    static int minInsertions(String s) {
        int n = s.length();
        String r = new StringBuilder(s).reverse().toString();
        int[] prev = new int[n + 1], cur = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                cur[j] = s.charAt(i - 1) == r.charAt(j - 1) ? 1 + prev[j - 1] : Math.max(prev[j], cur[j - 1]);
            }
            int[] tmp = prev; prev = cur; cur = tmp;
        }
        return n - prev[n];
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("zzazz"));         // 0
        System.out.println(minInsertions("mbadm"));         // 2  ("mbdadbm")
        System.out.println(minInsertions("leetcode"));      // 5
        System.out.println(minInsertions("a"));             // 0
        System.out.println(minInsertions("ab"));            // 1
        System.out.println(minInsertions("abcd"));          // 3
    }
}
