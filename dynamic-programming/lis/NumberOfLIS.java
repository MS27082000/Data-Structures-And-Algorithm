/** Number of Longest Increasing Subsequences (LC 673): how many LIS (of maximum length) exist? */
public class NumberOfLIS {

    // Two arrays: len[i] = LIS length ending at i, cnt[i] = how many LIS of that length end at i.
    // For j < i with nums[j] < nums[i]: if len[j] + 1 > len[i] -> take it, cnt[i] = cnt[j]; if equal -> cnt[i] += cnt[j].
    // The answer sums cnt[i] over all i with len[i] == maxLen. O(n^2) time, O(n) space
    static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        int[] len = new int[n], cnt = new int[n];
        int maxLen = 0, total = 0;
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    } else if (len[j] + 1 == len[i]) {
                        cnt[i] += cnt[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }
        for (int i = 0; i < n; i++) if (len[i] == maxLen) total += cnt[i];
        return total;
    }

    public static void main(String[] args) {
        System.out.println(findNumberOfLIS(new int[]{1, 3, 5, 4, 7}));       // 2  ([1,3,4,7] and [1,3,5,7])
        System.out.println(findNumberOfLIS(new int[]{2, 2, 2, 2, 2}));       // 5  (each element alone is an LIS of length 1)
        System.out.println(findNumberOfLIS(new int[]{1, 2, 4, 3, 5, 4, 7, 2}));   // 3
        System.out.println(findNumberOfLIS(new int[]{5}));                   // 1
        System.out.println(findNumberOfLIS(new int[]{3, 2, 1}));             // 3
    }
}
