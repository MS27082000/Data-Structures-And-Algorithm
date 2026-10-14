/** Check if a Number is Odd or Even using the lowest bit */
public class OddOrEven {

    // The least significant bit is 1 for odd numbers. n & 1 works for NEGATIVE numbers too. O(1)
    static boolean isOdd(int n) {
        return (n & 1) == 1;
    }

    // Trap: n % 2 == 1 is WRONG for negatives in Java (-3 % 2 == -1), so use n % 2 != 0 or the bit check
    static boolean isOddModulo(int n) {
        return n % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(isOdd(7));                 // true
        System.out.println(isOdd(10));                // false
        System.out.println(isOdd(0));                 // false
        System.out.println(isOdd(-3));                // true  (works for negatives)
        System.out.println(isOdd(-4));                // false
        System.out.println(isOddModulo(-3));          // true
        System.out.println(-3 % 2 == 1);              // false  <- the classic trap
        System.out.println(isOdd(Integer.MIN_VALUE)); // false
    }
}
