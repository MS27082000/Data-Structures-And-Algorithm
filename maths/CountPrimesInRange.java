import java.util.Arrays;

/** Count primes in range [L, R]: prefix counts for many queries, and a segmented sieve for a huge R */
public class CountPrimesInRange {

    // Sieve up to the largest R once, then prefix[i] = number of primes <= i. Each query is prefix[R] - prefix[L-1] in O(1)
    static int[] primePrefix(int n) {
        boolean[] composite = new boolean[n + 1];
        for (int p = 2; (long) p * p <= n; p++)
            if (!composite[p]) for (int m = p * p; m <= n; m += p) composite[m] = true;
        int[] prefix = new int[n + 1];
        for (int i = 2; i <= n; i++) prefix[i] = prefix[i - 1] + (composite[i] ? 0 : 1);
        return prefix;
    }

    static int countInRange(int[] prefix, int l, int r) {
        if (r < 2 || l > r) return 0;
        return prefix[r] - prefix[Math.max(l, 2) - 1];
    }

    // Segmented sieve: when R is large (e.g. 10^12) but R - L is small (e.g. 10^6). Find the primes up to sqrt(R) with a normal sieve, then
    // cross out their multiples inside [L, R] only. O(sqrt(R) log log sqrt(R) + (R-L) log log R), O(sqrt(R) + R-L) space
    static int countSegmented(long l, long r) {
        if (r < 2) return 0;
        l = Math.max(l, 2);
        int limit = (int) Math.sqrt((double) r) + 1;
        boolean[] small = new boolean[limit + 1];
        Arrays.fill(small, true);
        int count = 0;
        boolean[] isPrimeInRange = new boolean[(int) (r - l + 1)];
        Arrays.fill(isPrimeInRange, true);
        for (int p = 2; p <= limit; p++) {
            if (!small[p]) continue;
            for (int m = p * p; m <= limit; m += p) small[m] = false;
            long start = Math.max((long) p * p, ((l + p - 1) / p) * p);       // first multiple of p in [l, r] (never p itself)
            for (long m = start; m <= r; m += p) isPrimeInRange[(int) (m - l)] = false;
        }
        for (boolean b : isPrimeInRange) if (b) count++;
        return count;
    }

    public static void main(String[] args) {
        int[] prefix = primePrefix(100);
        System.out.println(countInRange(prefix, 10, 30));                  // 6   (11, 13, 17, 19, 23, 29)
        System.out.println(countInRange(prefix, 1, 10));                   // 4   (2, 3, 5, 7)
        System.out.println(countInRange(prefix, 0, 1));                    // 0
        System.out.println(countInRange(prefix, 2, 2));                    // 1
        System.out.println(countInRange(prefix, 90, 100));                 // 1   (97)
        System.out.println(countSegmented(10, 30));                        // 6
        System.out.println(countSegmented(1, 100));                        // 25
        System.out.println(countSegmented(1_000_000_000L, 1_000_000_100L));   // 7   (1000000007, 009, 021, 033, 087, 093, 097)
    }
}
