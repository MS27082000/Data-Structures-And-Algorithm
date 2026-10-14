/** Minimum Number of Days to Make m Bouquets (LC 1482): each bouquet needs k ADJACENT bloomed flowers */
public class MinDaysToMakeBouquets {

    // Binary search on the day in [min(bloom), max(bloom)]; if possible on day d, also possible later. O(n log range), O(1)
    static int minDays(int[] bloomDay, int m, int k) {
        if ((long) m * k > bloomDay.length) return -1;       // not enough flowers at all
        int low = Integer.MAX_VALUE, high = 0;
        for (int d : bloomDay) {
            low = Math.min(low, d);
            high = Math.max(high, d);
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, m, k, mid)) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0, run = 0;
        for (int d : bloomDay) {
            if (d <= day) {
                run++;
                if (run == k) {
                    bouquets++;
                    run = 0;
                }
            } else {
                run = 0;                                     // adjacency broken
            }
        }
        return bouquets >= m;
    }

    public static void main(String[] args) {
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 1));          // 3
        System.out.println(minDays(new int[]{1, 10, 3, 10, 2}, 3, 2));          // -1
        System.out.println(minDays(new int[]{7, 7, 7, 7, 12, 7, 7}, 2, 3));     // 12
        System.out.println(minDays(new int[]{1000000000, 1000000000}, 1, 1));   // 1000000000
    }
}
