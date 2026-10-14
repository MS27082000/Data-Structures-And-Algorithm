import java.util.ArrayList;
import java.util.List;

/** Print all primes till N: trial division versus the Sieve of Eratosthenes */
public class PrintAllPrimesTillN {

    // Brute force: test each number by trial division up to sqrt(x). O(N * sqrt(N)) time
    static List<Integer> primesBrute(int n) {
        List<Integer> res = new ArrayList<>();
        for (int x = 2; x <= n; x++) {
            boolean prime = true;
            for (int d = 2; (long) d * d <= x; d++) {
                if (x % d == 0) { prime = false; break; }
            }
            if (prime) res.add(x);
        }
        return res;
    }

    // Sieve: assume everything is prime, then for every prime p cross out its multiples starting at p*p (smaller multiples were already crossed
    // out by smaller primes). O(N log log N) time, O(N) space
    static List<Integer> primesSieve(int n) {
        List<Integer> res = new ArrayList<>();
        if (n < 2) return res;
        boolean[] composite = new boolean[n + 1];
        for (int p = 2; (long) p * p <= n; p++) {
            if (!composite[p]) {
                for (int m = p * p; m <= n; m += p) composite[m] = true;
            }
        }
        for (int x = 2; x <= n; x++) if (!composite[x]) res.add(x);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(primesSieve(30));                                           // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29]
        System.out.println(primesBrute(30).equals(primesSieve(30)));                    // true
        System.out.println(primesSieve(2));                                             // [2]
        System.out.println(primesSieve(1));                                             // []
        System.out.println(primesSieve(0));                                             // []
        System.out.println(primesSieve(100).size());                                    // 25
        System.out.println(primesSieve(1_000_000).size());                              // 78498
    }
}
