import java.util.Arrays;

/** Right (Cyclic) Rotate Array by One Place */
public class RightRotateByOne {

    // Save last element, shift everything right (walking backward), put it at the front. O(n) time, O(1) space
    static void rightRotateByOne(int[] a) {
        if (a.length < 2) return;
        int last = a[a.length - 1];
        for (int i = a.length - 1; i > 0; i--) a[i] = a[i - 1];
        a[0] = last;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        rightRotateByOne(a);
        System.out.println(Arrays.toString(a));   // [5, 1, 2, 3, 4]

        int[] b = {7};
        rightRotateByOne(b);
        System.out.println(Arrays.toString(b));   // [7]
    }
}
