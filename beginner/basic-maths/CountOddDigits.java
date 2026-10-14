/** Count the number of odd digits in a number */
public class CountOddDigits {

    // Peel digits with % 10; a digit is odd if d % 2 == 1. O(log10 n) time, O(1) space
    static int countOddDigits(long n) {
        n = Math.abs(n);
        int count = 0;
        while (n > 0) {
            if ((n % 10) % 2 == 1) count++;
            n /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOddDigits(12345));       // 3  (1, 3, 5)
        System.out.println(countOddDigits(2468));        // 0
        System.out.println(countOddDigits(0));           // 0
        System.out.println(countOddDigits(-135));        // 3
        System.out.println(countOddDigits(9999999999L)); // 10
    }
}
