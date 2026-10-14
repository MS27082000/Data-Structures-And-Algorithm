/** Find the Smallest Divisor Given a Threshold (LC 1283): smallest d with sum(ceil(a[i]/d)) <= threshold */
public class SmallestDivisor {

    // Binary search on d in [1, max(a)]; feasibility is monotonic (bigger d => smaller sum). O(n log max), O(1)
    static int smallestDivisor(int[] a, int threshold) {
        int low = 1, high = 0;
        for (int x : a) high = Math.max(high, x);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (sumOfCeil(a, mid) <= threshold) high = mid;     // feasible, try smaller
            else low = mid + 1;
        }
        return low;
    }

    private static long sumOfCeil(int[] a, int d) {
        long sum = 0;
        for (int x : a) sum += (x + d - 1) / d;                 // ceil(x / d)
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(smallestDivisor(new int[]{1, 2, 5, 9}, 6));            // 5
        System.out.println(smallestDivisor(new int[]{44, 22, 33, 11, 1}, 5));     // 44
        System.out.println(smallestDivisor(new int[]{2, 3, 5, 7, 11}, 11));       // 3
        System.out.println(smallestDivisor(new int[]{19}, 5));                    // 4
    }
}
