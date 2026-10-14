import java.util.Arrays;

/** Reverse an array in place */
public class ReverseArray {

    // Two pointers swap from both ends until they meet. O(n) time, O(1) space. (Extra array = O(n) space, avoid it.)
    static void reverse(int[] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int t = arr[l];
            arr[l++] = arr[r];
            arr[r--] = t;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        reverse(a);
        System.out.println(Arrays.toString(a));                    // [5, 4, 3, 2, 1]
        int[] b = {1, 2, 3, 4};
        reverse(b);
        System.out.println(Arrays.toString(b));                    // [4, 3, 2, 1]
        int[] c = {9};
        reverse(c);
        System.out.println(Arrays.toString(c));                    // [9]
        int[] d = {};
        reverse(d);
        System.out.println(Arrays.toString(d));                    // []
    }
}
