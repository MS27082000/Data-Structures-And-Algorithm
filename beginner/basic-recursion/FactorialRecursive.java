/** Factorial of a given number using recursion */
public class FactorialRecursive {

    // n! = n * (n - 1)!, 0! = 1. O(n) time, O(n) stack. long overflows after 20!
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));       // 120
        System.out.println(factorial(0));       // 1
        System.out.println(factorial(1));       // 1
        System.out.println(factorial(10));      // 3628800
        System.out.println(factorial(20));      // 2432902008176640000
    }
}
