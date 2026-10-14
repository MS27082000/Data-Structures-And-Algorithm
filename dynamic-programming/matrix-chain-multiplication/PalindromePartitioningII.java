/** Palindrome Partitioning II (LC 132): minimum cuts so that every piece is a palindrome */
public class PalindromePartitioningII {

    // Precompute isPal[i][j] in O(n^2), then cuts[i] = min cuts for the prefix s[0..i]: 0 if the whole prefix is a palindrome, else
    // min over j of cuts[j-1] + 1 where s[j..i] is a palindrome. O(n^2) time and space
    static int minCut(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                pal[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || pal[i + 1][j - 1]);
            }
        }
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            if (pal[0][i]) { cuts[i] = 0; continue; }
            cuts[i] = i;                                            // worst case: cut between every character
            for (int j = 1; j <= i; j++) {
                if (pal[j][i]) cuts[i] = Math.min(cuts[i], cuts[j - 1] + 1);
            }
        }
        return n == 0 ? 0 : cuts[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));          // 1  ("aa" | "b")
        System.out.println(minCut("a"));            // 0
        System.out.println(minCut("ab"));           // 1
        System.out.println(minCut("racecar"));      // 0
        System.out.println(minCut("abcde"));        // 4
        System.out.println(minCut("aaabaa"));       // 1  ("a" | "aabaa")
    }
}
