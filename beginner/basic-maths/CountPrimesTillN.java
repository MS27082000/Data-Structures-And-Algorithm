/** Count of prime numbers till N (LC 204 counts primes strictly less than n) */
public class CountPrimesTillN {

    // Brute force: trial division for each number, O(n * sqrt n)
    static int countBrute(int n) {
        int count = 0;
        for (int x = 2; x <= n; x++) {
            boolean prime = true;
            for (int d = 2; (long) d * d <= x; d++) if (x % d == 0) { prime = false; break; }
            if (prime) count++;
        }
        return count;
    }

    // Sieve of Eratosthenes: O(n log log n) time, O(n) space
    static int countSieve(int n) {
        if (n < 2) return 0;
        boolean[] composite = new boolean[n + 1];
        int count = 0;
        for (int p = 2; p <= n; p++) {
            if (composite[p]) continue;
            count++;
            for (long m = (long) p * p; m <= n; m += p) composite[(int) m] = true;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSieve(10) + " " + countBrute(10));                 // 4 4   (2, 3, 5, 7)
        System.out.println(countSieve(100));                                        // 25
        System.out.println(countSieve(1) + " " + countSieve(0));                    // 0 0
        System.out.println(countSieve(2));                                          // 1
        System.out.println(countSieve(1_000_000));                                  // 78498
        System.out.println("LeetCode 204 (strictly below 10): " + countSieve(9));   // 4
    }
}
