import java.util.Arrays;

/** Longest Common Prefix (LC 14) */
public class LongestCommonPrefix {

    // Vertical scan: compare column by column against the first word. O(total characters) time, O(1) extra space
    static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    // Sorting trick: after sorting, only the first and last words can differ the most; compare just those. O(n log n * L)
    static String longestCommonPrefixSorted(String[] strs) {
        String[] a = strs.clone();
        Arrays.sort(a);
        String first = a[0], last = a[a.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) i++;
        return first.substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));        // fl
        System.out.println("[" + longestCommonPrefix(new String[]{"dog", "racecar", "car"}) + "]");   // []
        System.out.println(longestCommonPrefix(new String[]{"alone"}));                           // alone
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));                         // a
        System.out.println(longestCommonPrefixSorted(new String[]{"flower", "flow", "flight"}));  // fl
        System.out.println(longestCommonPrefix(new String[]{"", "abc"}).isEmpty());               // true
    }
}
