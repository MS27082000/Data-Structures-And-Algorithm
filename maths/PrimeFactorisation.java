import java.util.ArrayList;
import java.util.List;

/** Prime factorisation of a number: trial division, and the smallest-prime-factor (SPF) sieve for many queries */
public class PrimeFactorisation {

    // Divide out each factor d while d*d <= n. Whatever is left (> 1) is itself a prime. O(sqrt(n)) per number
    static List<Integer> factorise(int n) {
        List<Integer> res = new ArrayList<>();
        for (int d = 2; (long) d * d <= n; d++) {
            while (n % d == 0) { res.add(d); n /= d; }
        }
        if (n > 1) res.add(n);
        return res;
    }

    // Precompute spf[x] = smallest prime dividing x with a sieve; then each query is O(log x) by repeatedly dividing by spf. Preprocessing
    // O(N log log N), O(N) space
    static int[] buildSpf(int n) {
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++) spf[i] = i;
        for (int p = 2; (long) p * p <= n; p++) {
            if (spf[p] == p) {
                for (int m = p * p; m <= n; m += p) if (spf[m] == m) spf[m] = p;      // only set the first (smallest) prime
            }
        }
        return spf;
    }

    static List<Integer> factoriseSpf(int x, int[] spf) {
        List<Integer> res = new ArrayList<>();
        while (x > 1) {
            res.add(spf[x]);
            x /= spf[x];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(factorise(60));                       // [2, 2, 3, 5]
        System.out.println(factorise(97));                       // [97]   (prime)
        System.out.println(factorise(1));                        // []
        System.out.println(factorise(1024));                     // [2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
        System.out.println(factorise(2147483647));               // [2147483647]  (a Mersenne prime; the long cast avoids overflow of d*d)
        int[] spf = buildSpf(100);
        System.out.println(factoriseSpf(60, spf));               // [2, 2, 3, 5]
        System.out.println(factoriseSpf(91, spf));               // [7, 13]
        System.out.println(factoriseSpf(84, spf).equals(factorise(84)));   // true
    }
}
