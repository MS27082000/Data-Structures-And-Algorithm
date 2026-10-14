import java.util.Arrays;

/** Swap Two Numbers without a temporary variable */
public class SwapTwoNumbers {

    // XOR swap: a ^= b; b ^= a; a ^= b. Java is pass-by-value, so we swap two slots of an array to show the effect.
    // O(1) time, O(1) space
    static void swapXor(int[] v, int i, int j) {
        if (i == j) return;                 // TRAP: XOR-swapping a slot with itself zeroes it
        v[i] ^= v[j];
        v[j] ^= v[i];
        v[i] ^= v[j];
    }

    // Arithmetic swap (can overflow for large values, but wraps correctly in Java's two's complement)
    static void swapArithmetic(int[] v, int i, int j) {
        if (i == j) return;
        v[i] = v[i] + v[j];
        v[j] = v[i] - v[j];
        v[i] = v[i] - v[j];
    }

    // The tidy version everyone should actually write
    static void swapTemp(int[] v, int i, int j) {
        int t = v[i];
        v[i] = v[j];
        v[j] = t;
    }

    public static void main(String[] args) {
        int[] a = {5, 9};
        swapXor(a, 0, 1);
        System.out.println(Arrays.toString(a));         // [9, 5]

        int[] b = {-4, 7};
        swapArithmetic(b, 0, 1);
        System.out.println(Arrays.toString(b));         // [7, -4]

        int[] c = {Integer.MAX_VALUE, 1};
        swapArithmetic(c, 0, 1);                        // the intermediate sum overflows but the result is still right
        System.out.println(Arrays.toString(c));         // [1, 2147483647]

        int[] d = {3, 3};
        swapXor(d, 0, 1);
        System.out.println(Arrays.toString(d));         // [3, 3]  (equal values are fine)

        int[] e = {8, 2};
        swapXor(e, 0, 0);                               // same slot: guarded, nothing changes
        System.out.println(Arrays.toString(e));         // [8, 2]
        swapTemp(e, 0, 1);
        System.out.println(Arrays.toString(e));         // [2, 8]
    }
}
