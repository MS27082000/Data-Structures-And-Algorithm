import java.util.Arrays;

/** Left Rotate Array by K Places (also the idea behind LC 189 Rotate Array, which is a right rotation) */
public class LeftRotateByK {

    // Reversal algorithm: reverse(0..k-1), reverse(k..n-1), reverse(all). O(n) time, O(1) space
    static void leftRotate(int[] a, int k) {
        int n = a.length;
        if (n == 0) return;
        k %= n;                       // k can be larger than n
        if (k == 0) return;
        reverse(a, 0, k - 1);
        reverse(a, k, n - 1);
        reverse(a, 0, n - 1);
    }

    private static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int t = a[l];
            a[l++] = a[r];
            a[r--] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        leftRotate(a, 3);
        System.out.println(Arrays.toString(a));   // [4, 5, 6, 7, 1, 2, 3]

        int[] b = {1, 2, 3};
        leftRotate(b, 5);                         // 5 % 3 = 2
        System.out.println(Arrays.toString(b));   // [3, 1, 2]

        int[] c = {1, 2, 3};
        leftRotate(c, 3);
        System.out.println(Arrays.toString(c));   // [1, 2, 3]
    }
}
