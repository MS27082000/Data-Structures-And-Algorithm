/** Check for a perfect number: equals the sum of its proper divisors (6 = 1 + 2 + 3) */
public class PerfectNumber {

    // Divisors come in pairs (d, n/d), so loop only to sqrt(n). Skip n itself. O(sqrt n) time, O(1) space
    static boolean isPerfect(int n) {
        if (n <= 1) return false;
        long sum = 1;                                         // 1 divides everything
        for (int d = 2; (long) d * d <= n; d++) {
            if (n % d == 0) {
                sum += d;
                if (d != n / d) sum += n / d;                 // avoid counting a square root twice
            }
        }
        return sum == n;
    }

    public static void main(String[] args) {
        System.out.println(isPerfect(6));         // true
        System.out.println(isPerfect(28));        // true
        System.out.println(isPerfect(496));       // true
        System.out.println(isPerfect(12));        // false
        System.out.println(isPerfect(1));         // false  (its only proper divisor sum is 0)
        System.out.println(isPerfect(8128));      // true
    }
}
