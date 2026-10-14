/** Return the largest digit in a number */
public class LargestDigit {

    // Peel digits and keep the maximum; stop early at 9. O(log10 n) time, O(1) space
    static int largestDigit(long n) {
        n = Math.abs(n);
        int max = 0;
        while (n > 0) {
            max = Math.max(max, (int) (n % 10));
            if (max == 9) return 9;
            n /= 10;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largestDigit(7845));       // 8
        System.out.println(largestDigit(0));          // 0
        System.out.println(largestDigit(-4021));      // 4
        System.out.println(largestDigit(1111));       // 1
        System.out.println(largestDigit(90000));      // 9
    }
}
