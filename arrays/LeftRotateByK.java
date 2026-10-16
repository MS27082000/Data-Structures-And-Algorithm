import java.util.Arrays;

/**
 * Rotate an Array by K Places (in place).
 *
 * Left rotate by k  : [1,2,3,4,5,6,7], k=3  ->  [4,5,6,7,1,2,3]   (first k elements go to the back)
 * Right rotate by k : [1,2,3,4,5,6,7], k=3  ->  [5,6,7,1,2,3,4]   (last k elements go to the front)
 *
 * Both use the REVERSAL TRICK: split the array into two blocks A and B, and we want B A.
 * Reverse A, reverse B, then reverse the whole thing:  reverse( rev(A) rev(B) ) = B A.
 *
 * Time O(n), space O(1).
 */
public class LeftRotateByK {

    // ---------- LEFT rotation ----------
    // Blocks: A = a[0..k-1]  (the first k elements, which must move to the back)
    //         B = a[k..n-1]  (the rest)
    static void leftRotate(int[] a, int k) {
        int n = a.length;
        if (n == 0) return;

        // Rotating by n brings the array back to the start, so only k % n matters.
        // Example: n=3, k=5 behaves exactly like k=2.
        k = k % n;
        if (k == 0) return;           // nothing to do

        reverse(a, 0, k - 1);         // step 1: reverse A    -> [3,2,1 | 4,5,6,7]
        reverse(a, k, n - 1);         // step 2: reverse B    -> [3,2,1 | 7,6,5,4]
        reverse(a, 0, n - 1);         // step 3: reverse all  -> [4,5,6,7 | 1,2,3]
    }

    // ---------- RIGHT rotation (this is LeetCode 189) ----------
    // Blocks: A = a[0..n-k-1] (stays in the front part, moves right)
    //         B = a[n-k..n-1] (the last k elements, which must move to the front)
    static void rightRotate(int[] a, int k) {
        int n = a.length;
        if (n == 0) return;
        k = k % n;
        if (k == 0) return;

        reverse(a, 0, n - k - 1);     // reverse A    -> [4,3,2,1 | 5,6,7]
        reverse(a, n - k, n - 1);     // reverse B    -> [4,3,2,1 | 7,6,5]
        reverse(a, 0, n - 1);         // reverse all  -> [5,6,7 | 1,2,3,4]
    }

    // Reverse a[l..r] in place by swapping the two ends and walking inward.
    private static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        leftRotate(a, 3);
        System.out.println(Arrays.toString(a));   // [4, 5, 6, 7, 1, 2, 3]

        int[] b = {1, 2, 3, 4, 5, 6, 7};
        rightRotate(b, 3);
        System.out.println(Arrays.toString(b));   // [5, 6, 7, 1, 2, 3, 4]

        int[] c = {1, 2, 3};
        leftRotate(c, 5);                         // 5 % 3 = 2
        System.out.println(Arrays.toString(c));   // [3, 1, 2]

        int[] d = {1, 2, 3};
        rightRotate(d, 3);                        // 3 % 3 = 0, unchanged
        System.out.println(Arrays.toString(d));   // [1, 2, 3]
    }
}
