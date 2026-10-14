/** Check if a number is prime (recursive) */
public class PrimeCheckRecursive {

    // Recursively test divisors d = 2, 3, ... while d*d <= n. O(sqrt n) time, O(sqrt n) stack
    static boolean isPrime(int n, int d) {
        if (n < 2) return false;
        if ((long) d * d > n) return true;                  // no divisor up to sqrt(n)
        if (n % d == 0) return false;
        return isPrime(n, d + 1);
    }

    public static void main(String[] args) {
        System.out.println(isPrime(2, 2));       // true
        System.out.println(isPrime(1, 2));       // false
        System.out.println(isPrime(97, 2));      // true
        System.out.println(isPrime(100, 2));     // false
        System.out.println(isPrime(0, 2));       // false
        System.out.println(isPrime(7919, 2));    // true  (the 1000th prime)
    }
}
