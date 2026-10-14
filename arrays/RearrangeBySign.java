import java.util.Arrays;

/** Rearrange Array Elements by Sign (LC 2149): equal positives and negatives, alternate starting with positive, keep order */
public class RearrangeBySign {

    // Two write indices: positives go to even slots, negatives to odd slots. O(n) time, O(n) space
    static int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int pos = 0, neg = 1;
        for (int x : nums) {
            if (x > 0) {
                res[pos] = x;
                pos += 2;
            } else {
                res[neg] = x;
                neg += 2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3, 1, -2, -5, 2, -4})));  // [3, -2, 1, -5, 2, -4]
        System.out.println(Arrays.toString(rearrangeArray(new int[]{-1, 1})));                // [1, -1]
        System.out.println(Arrays.toString(rearrangeArray(new int[]{1, -1, 2, -2})));         // [1, -1, 2, -2]
    }
}
