import java.util.Arrays;

/** Aggressive Cows: place k cows in stalls so that the MINIMUM distance between any two cows is MAXIMISED */
public class AggressiveCows {

    // Sort, then binary search on the distance in [1, max - min]. Feasible(d) is true for small d. O(n log n + n log range)
    static int maxMinDistance(int[] stalls, int k) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[stalls.length - 1] - stalls[0], ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canPlace(stalls, k, mid)) {
                ans = mid;                     // feasible, try a larger distance
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    // Greedy: put the first cow in the first stall, then each next cow in the nearest stall >= dist away
    private static boolean canPlace(int[] stalls, int k, int dist) {
        int cows = 1, last = stalls[0];
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - last >= dist) {
                cows++;
                last = stalls[i];
                if (cows >= k) return true;
            }
        }
        return cows >= k;
    }

    public static void main(String[] args) {
        System.out.println(maxMinDistance(new int[]{0, 3, 4, 7, 10, 9}, 4));   // 3
        System.out.println(maxMinDistance(new int[]{4, 2, 1, 3, 6}, 2));       // 5
        System.out.println(maxMinDistance(new int[]{1, 2, 3}, 3));             // 1
        System.out.println(maxMinDistance(new int[]{1, 100}, 2));              // 99
    }
}
