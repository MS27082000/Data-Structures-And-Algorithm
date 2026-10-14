/** Koko Eating Bananas (LC 875): minimum speed k to finish all piles within h hours */
public class KokoEatingBananas {

    // Binary search on speed in [1, max(piles)]; hours needed decrease as speed increases. O(n log max), O(1)
    static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int p : piles) high = Math.max(high, p);
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (hoursNeeded(piles, mid) <= h) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static long hoursNeeded(int[] piles, int speed) {
        long hours = 0;
        for (int p : piles) hours += (p + speed - 1) / speed;     // ceil(p / speed)
        return hours;
    }

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));          // 4
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));    // 30
        System.out.println(minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));    // 23
        System.out.println(minEatingSpeed(new int[]{1000000000}, 2));           // 500000000
    }
}
