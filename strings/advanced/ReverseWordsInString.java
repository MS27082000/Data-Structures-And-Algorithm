import java.util.Arrays;

/** Reverse Words in a String (LC 151): reverse the order of words; trim and collapse extra spaces */
public class ReverseWordsInString {

    // Split on whitespace runs, then join from the end. O(n) time, O(n) space
    static String reverseWords(String s) {
        String[] parts = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = parts.length - 1; i >= 0; i--) {
            sb.append(parts[i]);
            if (i > 0) sb.append(' ');
        }
        return sb.toString();
    }

    // No split: scan from the right, find each word's boundaries and append it. O(n) time, O(n) space (the output)
    static String reverseWordsScan(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') i--;                 // skip spaces
            if (i < 0) break;
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') i--;                 // i now sits just before the word
            if (sb.length() > 0) sb.append(' ');
            sb.append(s, i + 1, end + 1);
        }
        return sb.toString();
    }

    // In place on a char array (what interviewers ask for when the language allows mutation):
    // 1) reverse the whole array, 2) reverse each word back, 3) squeeze out extra spaces. O(n) time, O(1) extra space
    static String reverseWordsInPlace(String s) {
        char[] a = s.toCharArray();
        int n = a.length;
        reverse(a, 0, n - 1);
        int w = 0;                                                    // write index
        for (int r = 0; r < n; ) {
            while (r < n && a[r] == ' ') r++;
            if (r == n) break;
            if (w > 0) a[w++] = ' ';
            int start = w;
            while (r < n && a[r] != ' ') a[w++] = a[r++];
            reverse(a, start, w - 1);
        }
        return new String(a, 0, w);
    }

    private static void reverse(char[] a, int l, int r) {
        while (l < r) { char t = a[l]; a[l++] = a[r]; a[r--] = t; }
    }

    public static void main(String[] args) {
        String[] tests = {"the sky is blue", "  hello world  ", "a good   example", "single", "   "};
        for (String t : tests) {
            System.out.println("[" + reverseWords(t) + "] [" + reverseWordsScan(t) + "] [" + reverseWordsInPlace(t) + "]");
        }
        // [blue is sky the] x3 | [world hello] x3 | [example good a] x3 | [single] x3 | [] x3
        System.out.println(Arrays.toString("a b".split(" ")));        // [a, b]
    }
}
