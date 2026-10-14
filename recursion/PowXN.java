/** Pow(x, n) (LC 50): compute x raised to n using fast exponentiation */
public class PowXN {

    // Binary exponentiation: x^n = (x^(n/2))^2, times x if n is odd. O(log n) time, O(log n) stack
    static double myPow(double x, int n) {
        long exp = n;                       // long: -Integer.MIN_VALUE overflows int
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        return power(x, exp);
    }

    private static double power(double x, long n) {
        if (n == 0) return 1.0;
        double half = power(x, n / 2);
        return (n % 2 == 0) ? half * half : half * half * x;
    }

    // Iterative version: O(log n) time, O(1) space
    static double myPowIterative(double x, int n) {
        long exp = n;
        if (exp < 0) {
            x = 1 / x;
            exp = -exp;
        }
        double result = 1.0;
        while (exp > 0) {
            if ((exp & 1) == 1) result *= x;
            x *= x;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));                       // 1024.0
        System.out.println(myPow(2.1, 3));                        // 9.261000000000001
        System.out.println(myPow(2.0, -2));                       // 0.25
        System.out.println(myPow(1.0, Integer.MIN_VALUE));        // 1.0
        System.out.println(myPow(5.0, 0));                        // 1.0
        System.out.println(myPowIterative(2.0, 10));              // 1024.0
        System.out.println(myPowIterative(2.0, -2));              // 0.25
    }
}
