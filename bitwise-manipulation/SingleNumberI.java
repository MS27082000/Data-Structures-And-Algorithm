/** Single Number I (LC 136): every element appears twice except one. Find it in O(n) time and O(1) space */
public class SingleNumberI {

    // XOR everything: x ^ x = 0 and x ^ 0 = x, so the pairs cancel and the single number remains. O(n), O(1)
    static int singleNumber(int[] nums) {
        int xor = 0;
        for (int x : nums) xor ^= x;
        return xor;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));               // 1
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));         // 4
        System.out.println(singleNumber(new int[]{1}));                     // 1
        System.out.println(singleNumber(new int[]{-1, -1, -7}));            // -7
        System.out.println(singleNumber(new int[]{0, 5, 0}));               // 5
    }
}
