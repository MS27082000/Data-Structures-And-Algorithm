import java.math.BigInteger;

/** Factorial of a given number */
public class Factorial {

    // Iterative product. O(n) time, O(1) space. long overflows after 20! = 2432902008176640000
    static long factorial(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }

    // For larger n use BigInteger (or a modulo if the question says "mod 1e9+7")
    static BigInteger factorialBig(int n) {
        BigInteger f = BigInteger.ONE;
        for (int i = 2; i <= n; i++) f = f.multiply(BigInteger.valueOf(i));
        return f;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));              // 120
        System.out.println(factorial(0));              // 1   (0! = 1 by definition)
        System.out.println(factorial(1));              // 1
        System.out.println(factorial(20));             // 2432902008176640000
        System.out.println(factorial(21));             // -4249290049419214848   (overflow!)
        System.out.println(factorialBig(25));          // 15511210043330985984000000
    }
}
