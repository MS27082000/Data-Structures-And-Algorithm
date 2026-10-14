/** Sum of digits of a number (recursive) */
public class SumOfDigits {

    // sum(n) = n % 10 + sum(n / 10); base: 0 -> 0. O(log10 n) time and stack
    static int sumOfDigits(long n) {
        n = Math.abs(n);
        if (n == 0) return 0;
        return (int) (n % 10) + sumOfDigits(n / 10);
    }

    public static void main(String[] args) {
        System.out.println(sumOfDigits(1234));          // 10
        System.out.println(sumOfDigits(0));             // 0
        System.out.println(sumOfDigits(-99));           // 18
        System.out.println(sumOfDigits(1000));          // 1
        System.out.println(sumOfDigits(999999999999L)); // 108
    }
}
