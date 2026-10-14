/** Check for a prime number */
public class PrimeCheck {

    // Brute force: try every divisor from 2 to n-1. O(n)
    static boolean isPrimeBrute(int n) {
        if (n < 2) return false;
        for (int d = 2; d < n; d++) if (n % d == 0) return false;
        return true;
    }

    // A composite number has a divisor <= sqrt(n). Also skip even numbers and step by 2. O(sqrt n) time, O(1) space
    static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n < 4) return true;                               // 2 and 3
        if (n % 2 == 0) return false;
        for (long d = 3; d * d <= n; d += 2) if (n % d == 0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(1) + " " + isPrime(2) + " " + isPrime(3) + " " + isPrime(4));    // false true true false
        System.out.println(isPrime(97) + " " + isPrimeBrute(97));                                   // true true
        System.out.println(isPrime(100));                                                           // false
        System.out.println(isPrime(0) + " " + isPrime(-7));                                         // false false
        System.out.println(isPrime(2147483647));                                                    // true  (long avoids d*d overflow)
        System.out.println(isPrime(1_000_000_007));                                                 // true
    }
}
