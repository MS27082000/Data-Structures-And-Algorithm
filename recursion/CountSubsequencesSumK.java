import java.util.Arrays;

/** Count all subsequences with sum K */
public class CountSubsequencesSumK {

    // Recursion returns a COUNT: count(take) + count(not take). O(2^n) time, O(n) stack
    static int count(int index, int[] a, int remaining) {
        if (index == a.length) return remaining == 0 ? 1 : 0;   // reach the end: valid only if the sum matched
        int take = count(index + 1, a, remaining - a[index]);
        int notTake = count(index + 1, a, remaining);
        return take + notTake;
    }

    // Memoised version (non-negative values): states = (index, remaining) => O(n * K) time and space
    static int countMemo(int[] a, int k) {
        int[][] memo = new int[a.length][k + 1];
        for (int[] row : memo) Arrays.fill(row, -1);
        return countMemo(a.length - 1, a, k, memo);
    }

    private static int countMemo(int index, int[] a, int remaining, int[][] memo) {
        if (remaining < 0) return 0;
        if (index < 0) return remaining == 0 ? 1 : 0;
        if (memo[index][remaining] != -1) return memo[index][remaining];
        int take = countMemo(index - 1, a, remaining - a[index], memo);
        int notTake = countMemo(index - 1, a, remaining, memo);
        return memo[index][remaining] = take + notTake;
    }

    public static void main(String[] args) {
        System.out.println(count(0, new int[]{1, 2, 3}, 3));            // 2  ([3], [1,2])
        System.out.println(count(0, new int[]{1, 2, 3, 4, 5}, 5));      // 3  ([5], [1,4], [2,3])
        System.out.println(count(0, new int[]{0, 0}, 0));               // 4  (zeros: every subset counts)
        System.out.println(count(0, new int[]{}, 0));                   // 1
        System.out.println(countMemo(new int[]{1, 2, 3, 4, 5}, 5));     // 3
        System.out.println(countMemo(new int[]{4, 9, 2, 5, 1}, 10));    // 2
    }
}
