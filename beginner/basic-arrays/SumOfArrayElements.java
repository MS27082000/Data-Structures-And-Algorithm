/** Sum of array elements */
public class SumOfArrayElements {

    // One pass. Use long when values or length are large (int overflows past ~2.1e9). O(n) time, O(1) space
    static long sum(int[] arr) {
        long total = 0;
        for (int x : arr) total += x;
        return total;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4, 5}));                         // 15
        System.out.println(sum(new int[]{}));                                       // 0
        System.out.println(sum(new int[]{-5, 5}));                                  // 0
        System.out.println(sum(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE}));   // 4294967294  (an int accumulator would overflow)
        System.out.println(sum(new int[]{7}));                                      // 7
    }
}
