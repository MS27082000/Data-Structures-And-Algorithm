/** Repeated Substring Pattern (LC 459): is s made of one substring repeated 2+ times? */
public class RepeatedSubstringPattern {

    // If s is built from a repeated block, s appears inside (s + s) with the first and last char removed. O(n)
    static boolean repeatedSubstringPattern(String s) {
        return (s + s).substring(1, 2 * s.length() - 1).contains(s);
    }

    // Brute force: try each length that divides n. O(n * d(n))
    static boolean repeatedSubstringPatternBrute(String s) {
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len != 0) continue;
            String block = s.substring(0, len);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n / len; i++) sb.append(block);
            if (sb.toString().equals(s)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));          // true
        System.out.println(repeatedSubstringPattern("aba"));           // false
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));  // true
        System.out.println(repeatedSubstringPatternBrute("abab"));     // true
        System.out.println(repeatedSubstringPattern("a"));             // false
    }
}
