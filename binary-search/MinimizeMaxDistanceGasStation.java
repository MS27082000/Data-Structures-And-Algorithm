/** Minimise Maximum Distance between Gas Stations after adding k new stations anywhere (LC 774) */
public class MinimizeMaxDistanceGasStation {

    // Binary search on a real-valued distance until the range is < 1e-6. O(n log(range / eps)), O(1)
    static double minimiseMaxDistance(int[] stations, int k) {
        double low = 0, high = 0;
        for (int i = 1; i < stations.length; i++) high = Math.max(high, stations[i] - stations[i - 1]);
        while (high - low > 1e-6) {
            double mid = (low + high) / 2.0;
            if (stationsNeeded(stations, mid) <= k) high = mid;    // possible, try a smaller distance
            else low = mid;
        }
        return high;
    }

    // number of extra stations needed so that every gap is <= dist
    private static int stationsNeeded(int[] st, double dist) {
        int count = 0;
        for (int i = 1; i < st.length; i++) {
            int gap = st[i] - st[i - 1];
            int pieces = (int) (gap / dist);
            if (gap == dist * pieces) pieces--;                    // exact fit needs one fewer station
            count += pieces;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.printf("%.2f%n", minimiseMaxDistance(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 9));          // 0.50
        System.out.printf("%.2f%n", minimiseMaxDistance(new int[]{23, 24, 36, 39, 46, 56, 57, 65, 84, 98}, 1)); // 14.00
        System.out.printf("%.2f%n", minimiseMaxDistance(new int[]{0, 10}, 1));                                   // 5.00
        System.out.printf("%.2f%n", minimiseMaxDistance(new int[]{0, 10}, 0));                                   // 10.00
    }
}
