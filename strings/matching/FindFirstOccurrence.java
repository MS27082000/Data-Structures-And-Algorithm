/** Find the Index of the First Occurrence in a String (LC 28), also called strStr. */
public class FindFirstOccurrence {

    // Try each start index and compare. O(n * m) time, O(1) space
    static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        for (int i = 0; i + m <= n; i++) {
            int j = 0;
            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) j++;
            if (j == m) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));   // 0
        System.out.println(strStr("leetcode", "leeto"));  // -1
        System.out.println(strStr("abc", ""));            // 0
        System.out.println(strStr("a", "a"));             // 0
    }
}
