/** Sum of the first N natural numbers */
public class SumOfFirstNNumbers {

    // Recursion: sum(n) = n + sum(n - 1), sum(0) = 0. O(n) time, O(n) stack
    static long sum(int n) {
        if (n <= 0) return 0;
        return n + sum(n - 1);
    }

    // Maths: n * (n + 1) / 2. O(1)
    static long sumFormula(long n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(sum(5) + " " + sumFormula(5));          // 15 15
        System.out.println(sum(1) + " " + sumFormula(1));          // 1 1
        System.out.println(sum(0) + " " + sumFormula(0));          // 0 0
        System.out.println(sum(100) + " " + sumFormula(100));      // 5050 5050
        System.out.println(sumFormula(100_000));                   // 5000050000  (needs long)
    }
}
