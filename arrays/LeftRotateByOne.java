import java.util.Arrays;

/** Left Rotate Array by One Place */
public class LeftRotateByOne {

    // Save first element, shift everything left, put it at the end. O(n) time, O(1) space
    static void leftRotateByOne(int[] a) {
        if (a.length < 2) return;
        int first = a[0];
        for (int i = 1; i < a.length; i++) a[i - 1] = a[i];
        a[a.length - 1] = first;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        leftRotateByOne(a);
        System.out.println(Arrays.toString(a));   // [2, 3, 4, 5, 1]

        int[] b = {7};
        leftRotateByOne(b);
        System.out.println(Arrays.toString(b));   // [7]
    }
}
