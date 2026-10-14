import java.util.Arrays;

/** Single Number III (LC 260): every element appears twice except TWO elements that appear once. Find both. O(n) time, O(1) space */
public class SingleNumberIII {

    static int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int x : nums) xor ^= x;                 // = a ^ b (the two unique numbers); the pairs cancelled
        int lowestBit = xor & -xor;                  // a set bit of (a ^ b): a and b DIFFER at this bit
        int a = 0, b = 0;
        for (int x : nums) {
            if ((x & lowestBit) != 0) a ^= x;        // group 1: numbers with that bit set
            else b ^= x;                             // group 2: numbers with that bit clear
        }
        return new int[]{a, b};                      // each group holds one unique number plus cancelling pairs
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(singleNumber(new int[]{1, 2, 1, 3, 2, 5})));          // [5, 3] (any order)
        System.out.println(Arrays.toString(singleNumber(new int[]{-1, 0})));                     // [0, -1] (any order)
        System.out.println(Arrays.toString(singleNumber(new int[]{0, 1})));                      // [1, 0] (any order)
        System.out.println(Arrays.toString(singleNumber(new int[]{Integer.MIN_VALUE, 7})));      // handles MIN_VALUE: xor & -xor still works
        System.out.println(Arrays.toString(singleNumber(new int[]{4, 4, 9, 6, 6, 10})));         // [9, 10] (any order)
    }
}
