import java.util.Arrays;

/** Next Permutation (LC 31): rearrange in place into the next lexicographically greater permutation */
public class NextPermutation {

    // O(n) time, O(1) space
    static void nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) i--;      // 1) find the first dip from the right (pivot)
        if (i >= 0) {
            int j = n - 1;
            while (a[j] <= a[i]) j--;                // 2) smallest element on the right that is > pivot
            swap(a, i, j);
        }
        reverse(a, i + 1, n - 1);                    // 3) reverse the suffix (it was descending => make ascending)
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) swap(a, l++, r--);
    }

    public static void main(String[] args) {
        int[][] tests = {{1, 2, 3}, {3, 2, 1}, {1, 1, 5}, {1, 3, 2}, {2, 3, 1}, {1}, {1, 5, 1}};
        for (int[] t : tests) {
            nextPermutation(t);
            System.out.println(Arrays.toString(t));
        }
        // [1, 3, 2] [1, 2, 3] [1, 5, 1] [2, 1, 3] [3, 1, 2] [1] [5, 1, 1]
    }
}
