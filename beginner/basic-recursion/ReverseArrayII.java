import java.util.Arrays;

/** Reverse an array using recursion */
public class ReverseArrayII {

    // Swap arr[l] and arr[r], then recurse inwards. O(n) time, O(n) stack, in place
    static void reverse(int[] arr, int l, int r) {
        if (l >= r) return;
        int t = arr[l]; arr[l] = arr[r]; arr[r] = t;
        reverse(arr, l + 1, r - 1);
    }

    // Single-index version: swap arr[i] with arr[n - 1 - i], stop at the middle
    static void reverseOneIndex(int[] arr, int i) {
        if (i >= arr.length / 2) return;
        int j = arr.length - 1 - i;
        int t = arr[i]; arr[i] = arr[j]; arr[j] = t;
        reverseOneIndex(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        reverse(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));          // [5, 4, 3, 2, 1]
        int[] b = {1, 2, 3, 4};
        reverseOneIndex(b, 0);
        System.out.println(Arrays.toString(b));          // [4, 3, 2, 1]
        int[] c = {7};
        reverse(c, 0, 0);
        System.out.println(Arrays.toString(c));          // [7]
        int[] d = {};
        reverse(d, 0, -1);
        System.out.println(Arrays.toString(d));          // []
    }
}
