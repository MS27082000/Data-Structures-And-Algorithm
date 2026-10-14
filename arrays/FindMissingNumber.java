/** Missing Number (LC 268): array holds n distinct numbers from 0..n, find the missing one */
public class FindMissingNumber {

    // XOR approach: no overflow, O(n) time, O(1) space
    static int missingNumber(int[] nums) {
        int xor = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xor ^= i ^ nums[i];
        }
        return xor;
    }

    // Sum approach (alternative): expected sum n(n+1)/2 - actual sum
    static int missingNumberSum(int[] nums) {
        long n = nums.length;
        long sum = 0;
        for (int x : nums) sum += x;
        return (int) (n * (n + 1) / 2 - sum);
    }

    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{3, 0, 1}));                         // 2
        System.out.println(missingNumber(new int[]{0, 1}));                            // 2
        System.out.println(missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));       // 8
        System.out.println(missingNumberSum(new int[]{3, 0, 1}));                      // 2
        System.out.println(missingNumber(new int[]{0}));                               // 1
    }
}
