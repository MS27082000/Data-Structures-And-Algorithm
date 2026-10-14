/** Painter's Partition: k painters, boards painted in contiguous groups; minimise the time of the slowest painter */
public class PaintersPartition {

    // Binary search on the answer (max load) in [max(board), sum(boards)]. Identical to Book Allocation / Split Array. O(n log sum), O(1)
    static int minTime(int[] boards, int k) {
        if (k > boards.length) return -1;                     // (Book Allocation convention; painters can idle otherwise)
        int low = 0, high = 0;
        for (int b : boards) {
            low = Math.max(low, b);
            high += b;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (paintersNeeded(boards, mid) <= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static int paintersNeeded(int[] boards, int limit) {
        int painters = 1, load = 0;
        for (int b : boards) {
            if (load + b > limit) {
                painters++;
                load = b;
            } else {
                load += b;
            }
        }
        return painters;
    }

    public static void main(String[] args) {
        System.out.println(minTime(new int[]{10, 20, 30, 40}, 2));    // 60
        System.out.println(minTime(new int[]{5, 5, 5, 5}, 2));        // 10
        System.out.println(minTime(new int[]{10, 20, 30, 40}, 4));    // 40
        System.out.println(minTime(new int[]{10, 20, 30, 40}, 1));    // 100
        System.out.println(minTime(new int[]{10, 20}, 3));            // -1
    }
}
