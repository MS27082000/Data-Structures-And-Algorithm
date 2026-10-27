/** Is Subsequence (LC 392): is s a subsequence of t? */
public class IsSubsequence {

    // One pointer on s, scan t. O(|t|) time, O(1) space
    static boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length() && i < s.length(); j++) {
            if (s.charAt(i) == t.charAt(j)) i++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(isSubsequence("abc", "ahbgdc")); // true
        System.out.println(isSubsequence("axc", "ahbgdc")); // false
        System.out.println(isSubsequence("", "abc"));       // true
        System.out.println(isSubsequence("a", ""));         // false
    }
}
