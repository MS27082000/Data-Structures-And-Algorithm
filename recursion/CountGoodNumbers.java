/** Count Good Numbers (LC 1922): digit string of length n is good if even indices hold even digits (0,2,4,6,8)
 *  and odd indices hold primes (2,3,5,7). Return the count modulo 1e9+7. */
public class CountGoodNumbers {

    private static final long MOD = 1_000_000_007L;

    // Even indices: 5 choices each (ceil(n/2) of them). Odd indices: 4 choices each (floor(n/2) of them).
    // Answer = 5^ceil(n/2) * 4^floor(n/2) mod M. O(log n) time
    static int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2, oddPositions = n / 2;
        return (int) (modPow(5, evenPositions) * modPow(4, oddPositions) % MOD);
    }

    // Fast exponentiation with a modulus. Multiply inside long so nothing overflows.
    private static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));                   // 5
        System.out.println(countGoodNumbers(4));                   // 400
        System.out.println(countGoodNumbers(50));                  // 564908303
        System.out.println(countGoodNumbers(2));                   // 20
        System.out.println(countGoodNumbers(1_000_000_000_000_000L)); // large n, no overflow
    }
}
