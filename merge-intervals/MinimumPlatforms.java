import java.util.Arrays;

/** Minimum Number of Platforms Required for a Railway Station */
public class MinimumPlatforms {

    // Sort arrivals and departures separately, then sweep like merging two sorted lists:
    // an arrival (<= next departure) needs a platform; a departure frees one. Track the maximum in use.
    // O(n log n) time, O(1) extra space (besides sorting copies)
    static int findPlatform(int[] arr, int[] dep) {
        int[] a = arr.clone(), d = dep.clone();
        Arrays.sort(a);
        Arrays.sort(d);
        int platforms = 0, maxPlatforms = 0, i = 0, j = 0, n = a.length;
        while (i < n) {
            if (a[i] <= d[j]) {                  // train arrives before (or exactly when) the earliest one leaves
                platforms++;
                i++;
            } else {                             // earliest train has left
                platforms--;
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platforms);
        }
        return maxPlatforms;
    }

    public static void main(String[] args) {
        System.out.println(findPlatform(new int[]{900, 940, 950, 1100, 1500, 1800},
                new int[]{910, 1200, 1120, 1130, 1900, 2000}));                  // 3
        System.out.println(findPlatform(new int[]{900, 1100, 1235}, new int[]{1000, 1200, 1240}));   // 1
        System.out.println(findPlatform(new int[]{900, 900, 900}, new int[]{1000, 1000, 1000}));      // 3
        System.out.println(findPlatform(new int[]{900, 1000}, new int[]{1000, 1100}));                // 2 (same minute needs 2)
        System.out.println(findPlatform(new int[]{}, new int[]{}));                                   // 0
    }
}
