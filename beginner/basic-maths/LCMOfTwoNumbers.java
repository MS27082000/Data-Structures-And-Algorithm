/** LCM of two numbers */
public class LCMOfTwoNumbers {

    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // a * b = gcd * lcm  =>  lcm = a / gcd * b. Divide FIRST so the intermediate value cannot overflow. O(log min(a, b))
    static long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return a / gcd(a, b) * b;
    }

    // Brute force: count up from max(a, b) until divisible by both. O(a * b) worst case
    static long lcmBrute(long a, long b) {
        long m = Math.max(a, b);
        while (m % a != 0 || m % b != 0) m++;
        return m;
    }

    public static void main(String[] args) {
        System.out.println(lcm(4, 6) + " " + lcmBrute(4, 6));        // 12 12
        System.out.println(lcm(5, 7));                               // 35
        System.out.println(lcm(12, 12));                             // 12
        System.out.println(lcm(1, 99));                              // 99
        System.out.println(lcm(1_000_000_007L, 998_244_353L));       // 998244359987710471  (product of two primes, fits in long)
        System.out.println(lcm(0, 5));                               // 0
    }
}
