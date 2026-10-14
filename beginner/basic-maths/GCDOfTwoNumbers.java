/** GCD (HCF) of two numbers */
public class GCDOfTwoNumbers {

    // Brute force: try every number from min(a, b) down to 1. O(min(a, b))
    static int gcdBrute(int a, int b) {
        for (int d = Math.min(a, b); d >= 1; d--) if (a % d == 0 && b % d == 0) return d;
        return Math.max(a, b);                                // one of them is 0
    }

    // Euclid: gcd(a, b) = gcd(b, a % b); stop when b is 0. O(log min(a, b)) time, O(1) space
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return Math.abs(a);
    }

    static int gcdRecursive(int a, int b) {
        return b == 0 ? a : gcdRecursive(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(20, 15) + " " + gcdBrute(20, 15) + " " + gcdRecursive(20, 15));   // 5 5 5
        System.out.println(gcd(9, 8));            // 1   (co-prime)
        System.out.println(gcd(0, 7));            // 7
        System.out.println(gcd(12, 12));          // 12
        System.out.println(gcd(1071, 462));       // 21
        System.out.println(gcd(7, 0));            // 7
    }
}
