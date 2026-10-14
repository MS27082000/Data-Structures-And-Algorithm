/** Time complexity with examples: count the basic operations of each loop shape */
public class TimeComplexity {

    static long ops;

    static void constant(int n)   { ops = 1; }                                                                   // O(1)
    static void logarithmic(int n){ ops = 0; for (int i = n; i > 1; i /= 2) ops++; }                             // O(log n): halves each step
    static void linear(int n)     { ops = 0; for (int i = 0; i < n; i++) ops++; }                                // O(n)
    static void linearithmic(int n){ ops = 0; for (int i = 0; i < n; i++) for (int j = n; j > 1; j /= 2) ops++; } // O(n log n)
    static void quadratic(int n)  { ops = 0; for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) ops++; }    // O(n^2)
    static void triangle(int n)   { ops = 0; for (int i = 0; i < n; i++) for (int j = 0; j < i; j++) ops++; }    // still O(n^2): n(n-1)/2
    static void sqrt(int n)       { ops = 0; for (long i = 1; i * i <= n; i++) ops++; }                          // O(sqrt n)
    static void exponential(int n){ ops = 0; fib(n); }                                                           // O(2^n)

    static int fib(int n) {
        ops++;
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        int n = 1024;
        constant(n);      System.out.println("O(1)       " + ops);       // 1
        logarithmic(n);   System.out.println("O(log n)   " + ops);       // 10
        sqrt(n);          System.out.println("O(sqrt n)  " + ops);       // 32
        linear(n);        System.out.println("O(n)       " + ops);       // 1024
        linearithmic(n);  System.out.println("O(n log n) " + ops);       // 10240
        quadratic(n);     System.out.println("O(n^2)     " + ops);       // 1048576
        triangle(n);      System.out.println("n(n-1)/2   " + ops);       // 523776
        exponential(20);  System.out.println("O(2^n) n=20 " + ops);      // 21891
    }
}
