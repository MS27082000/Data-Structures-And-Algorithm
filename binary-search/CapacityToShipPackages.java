/** Capacity To Ship Packages Within D Days (LC 1011): packages must be shipped IN ORDER */
public class CapacityToShipPackages {

    // Binary search on capacity in [max(w), sum(w)]. O(n log(sum)), O(1)
    static int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for (int w : weights) {
            low = Math.max(low, w);                  // must carry the heaviest package
            high += w;                               // one day carries everything
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (daysNeeded(weights, mid) <= days) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static int daysNeeded(int[] weights, int cap) {
        int days = 1, load = 0;
        for (int w : weights) {
            if (load + w > cap) {
                days++;
                load = 0;
            }
            load += w;
        }
        return days;
    }

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 5));  // 15
        System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));               // 6
        System.out.println(shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4));                  // 3
        System.out.println(shipWithinDays(new int[]{5}, 1));                              // 5
    }
}
