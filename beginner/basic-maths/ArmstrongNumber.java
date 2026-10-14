/** Check if a number is an Armstrong number: the sum of its digits each raised to the power (number of digits) equals the number */
public class ArmstrongNumber {

    // 153 = 1^3 + 3^3 + 5^3. Count digits first, then sum d^k. O(log n * log n) time, O(1) space
    static boolean isArmstrong(int n) {
        if (n < 0) return false;
        int digits = String.valueOf(n).length();
        long sum = 0;
        int temp = n;
        while (temp > 0) {
            sum += pow(temp % 10, digits);
            temp /= 10;
        }
        return sum == n;
    }

    private static long pow(int base, int exp) {
        long r = 1;
        for (int i = 0; i < exp; i++) r *= base;
        return r;
    }

    public static void main(String[] args) {
        System.out.println(isArmstrong(153));     // true
        System.out.println(isArmstrong(371));     // true
        System.out.println(isArmstrong(9474));    // true   (4 digits: 9^4 + 4^4 + 7^4 + 4^4)
        System.out.println(isArmstrong(123));     // false
        System.out.println(isArmstrong(0));       // true
        System.out.println(isArmstrong(5));       // true   (every single digit is Armstrong)
    }
}
