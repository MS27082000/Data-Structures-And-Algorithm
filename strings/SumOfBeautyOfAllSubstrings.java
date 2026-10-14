/** Sum of Beauty of All Substrings (LC 1781): beauty = (max char frequency) - (min char frequency among chars that appear) */
public class SumOfBeautyOfAllSubstrings {

    // For each start i, extend j and maintain a 26-size frequency array; scan 26 slots per substring.
    // O(26 * n^2) time, O(1) space
    static int beautySum(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] freq = new int[26];
            for (int j = i; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                int max = 0, min = Integer.MAX_VALUE;
                for (int f : freq) {
                    if (f > 0) {                         // ignore letters that don't appear
                        max = Math.max(max, f);
                        min = Math.min(min, f);
                    }
                }
                total += max - min;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(beautySum("aabcb"));        // 5
        System.out.println(beautySum("aabcbaa"));      // 17
        System.out.println(beautySum("a"));            // 0
        System.out.println(beautySum("abc"));          // 0
        System.out.println(beautySum("aaab"));         // 3  (aaab = 2, aab = 1)
    }
}
