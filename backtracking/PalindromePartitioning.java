import java.util.ArrayList;
import java.util.List;

/** Palindrome Partitioning (LC 131): all ways to split s so every piece is a palindrome */
public class PalindromePartitioning {

    // At each start index try every end index; recurse only if s[start..end] is a palindrome.
    // O(n * 2^n) time, O(n) stack
    static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(0, s, new ArrayList<>(), res);
        return res;
    }

    private static void backtrack(int start, String s, List<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            if (isPalindrome(s, start, end)) {
                path.add(s.substring(start, end + 1));
                backtrack(end + 1, s, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private static boolean isPalindrome(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(partition("aab"));        // [[a, a, b], [aa, b]]
        System.out.println(partition("a"));          // [[a]]
        System.out.println(partition("aaa"));        // [[a, a, a], [a, aa], [aa, a], [aaa]]
        System.out.println(partition("abc"));        // [[a, b, c]]
    }
}
