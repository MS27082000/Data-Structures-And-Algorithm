import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** Print all divisors of a number */
public class DivisorsOfNumber {

    // Brute force: test 1..n. O(n)
    static List<Integer> divisorsBrute(int n) {
        List<Integer> res = new ArrayList<>();
        for (int d = 1; d <= n; d++) if (n % d == 0) res.add(d);
        return res;
    }

    // Divisors pair up as (d, n/d). Loop d to sqrt(n), add both, then sort. O(sqrt n + k log k) time, O(k) space
    static List<Integer> divisors(int n) {
        List<Integer> res = new ArrayList<>();
        for (int d = 1; (long) d * d <= n; d++) {
            if (n % d == 0) {
                res.add(d);
                if (d != n / d) res.add(n / d);               // a perfect square's root must not be added twice
            }
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(divisors(36) + " " + divisorsBrute(36).equals(divisors(36)));    // [1, 2, 3, 4, 6, 9, 12, 18, 36] true
        System.out.println(divisors(1));                                                      // [1]
        System.out.println(divisors(13));                                                     // [1, 13]
        System.out.println(divisors(100));                                                    // [1, 2, 4, 5, 10, 20, 25, 50, 100]
        System.out.println(divisors(2147483647));                                             // [1, 2147483647]
    }
}
