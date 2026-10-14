/** Count Number of Substrings with exactly K distinct characters (lowercase letters) */
public class CountSubstringsWithKDistinct {

    // exactly(K) = atMost(K) - atMost(K-1). atMost uses a sliding window. O(n) time, O(1) space (26 counters)
    static long countExactlyK(String s, int k) {
        if (k <= 0) return 0;
        return atMost(s, k) - atMost(s, k - 1);
    }

    private static long atMost(String s, int k) {
        if (k < 0) return 0;
        int[] freq = new int[26];
        int left = 0, distinct = 0;
        long count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (freq[s.charAt(right) - 'a']++ == 0) distinct++;
            while (distinct > k) {                           // shrink until valid again
                if (--freq[s.charAt(left) - 'a'] == 0) distinct--;
                left++;
            }
            count += right - left + 1;                       // all substrings ending at 'right' with <= k distinct
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countExactlyK("abc", 2));        // 2   (ab, bc)
        System.out.println(countExactlyK("aba", 2));        // 3   (ab, ba, aba)
        System.out.println(countExactlyK("pqpqs", 2));      // 7
        System.out.println(countExactlyK("aaa", 1));        // 6
        System.out.println(countExactlyK("abc", 4));        // 0
        System.out.println(countExactlyK("", 1));           // 0
    }
}
