/** Number of Substrings Containing All Three Characters (LC 1358): s contains only 'a', 'b', 'c' */
public class SubstringsContainingAllThreeChars {

    // For each right end, the valid starts are 0..min(lastSeen[a], lastSeen[b], lastSeen[c]). Add min + 1. O(n) time, O(1) space
    static int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1};
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            int earliest = Math.min(last[0], Math.min(last[1], last[2]));   // -1 if some letter hasn't appeared yet
            count += earliest + 1;                                            // starts 0..earliest all work (0 if -1)
        }
        return count;
    }

    // Classic window version: for each left, find the smallest right that completes the set; everything after also works
    static int numberOfSubstringsWindow(String s) {
        int[] freq = new int[3];
        int left = 0, count = 0, n = s.length();
        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;
            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += n - right;                                           // [left..right], [left..right+1], ... [left..n-1]
                freq[s.charAt(left++) - 'a']--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSubstrings("abcabc"));          // 10
        System.out.println(numberOfSubstrings("aaacb"));           // 3
        System.out.println(numberOfSubstrings("abc"));             // 1
        System.out.println(numberOfSubstrings("aabb"));            // 0
        System.out.println(numberOfSubstringsWindow("abcabc"));    // 10
        System.out.println(numberOfSubstringsWindow("aaacb"));     // 3
    }
}
