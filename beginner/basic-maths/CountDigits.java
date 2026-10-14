/** Count all digits of a number */
public class CountDigits {

    // Divide by 10 until nothing is left. O(log10 n) time, O(1) space. 0 has one digit
    static int countDigits(long n) {
        n = Math.abs(n);
        if (n == 0) return 1;
        int count = 0;
        while (n > 0) { count++; n /= 10; }
        return count;
    }

    // Math version: floor(log10(n)) + 1 (floating point, so be careful near powers of 10)
    static int countDigitsLog(long n) {
        n = Math.abs(n);
        return n == 0 ? 1 : (int) Math.log10(n) + 1;
    }

    public static void main(String[] args) {
        System.out.println(countDigits(7789) + " " + countDigitsLog(7789));        // 4 4
        System.out.println(countDigits(0));                                         // 1
        System.out.println(countDigits(-120));                                      // 3
        System.out.println(countDigits(1_000_000_000_000L));                        // 13
        System.out.println(countDigits(9));                                         // 1
    }
}
