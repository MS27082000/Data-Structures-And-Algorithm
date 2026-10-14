/** Split Array Largest Sum (LC 410): split into k non-empty contiguous subarrays, minimise the largest subarray sum */
public class SplitArrayLargestSum {

    // Binary search on the largest sum in [max(a), sum(a)]. Same template as Painter's Partition / Book Allocation. O(n log sum), O(1)
    static int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int x : nums) {
            low = Math.max(low, x);
            high += x;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (partsNeeded(nums, mid) <= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static int partsNeeded(int[] nums, int limit) {
        int parts = 1, sum = 0;
        for (int x : nums) {
            if (sum + x > limit) {
                parts++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return parts;
    }

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 2));        // 18
        System.out.println(splitArray(new int[]{1, 2, 3, 4, 5}, 2));         // 9
        System.out.println(splitArray(new int[]{1, 4, 4}, 3));               // 4
        System.out.println(splitArray(new int[]{10}, 1));                    // 10
    }
}
