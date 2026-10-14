/** Kth Missing Positive Number (LC 1539): array is sorted, strictly increasing, positive */
public class KthMissingPositiveNumber {

    // missing(i) = a[i] - (i + 1) numbers are missing before index i. Find the first index with missing >= k.
    // Answer = k + (number of array elements before that point) = k + low. O(log n), O(1)
    static int findKthPositive(int[] a, int k) {
        int low = 0, high = a.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (a[mid] - (mid + 1) >= k) high = mid;
            else low = mid + 1;
        }
        return low + k;
    }

    public static void main(String[] args) {
        System.out.println(findKthPositive(new int[]{2, 3, 4, 7, 11}, 5));   // 9
        System.out.println(findKthPositive(new int[]{1, 2, 3, 4}, 2));       // 6
        System.out.println(findKthPositive(new int[]{5, 6, 7}, 2));          // 2
        System.out.println(findKthPositive(new int[]{2}, 1));                // 1
    }
}
