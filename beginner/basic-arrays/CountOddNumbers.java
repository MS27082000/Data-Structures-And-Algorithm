/** Count of odd numbers in an array */
public class CountOddNumbers {

    // Test with x % 2 != 0 (NOT == 1: negative odd numbers give -1 in Java) or (x & 1) == 1. O(n) time, O(1) space
    static int countOdd(int[] arr) {
        int count = 0;
        for (int x : arr) if ((x & 1) == 1) count++;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countOdd(new int[]{1, 2, 3, 4, 5}));      // 3
        System.out.println(countOdd(new int[]{2, 4, 6}));            // 0
        System.out.println(countOdd(new int[]{-3, -2, -1}));         // 2   (-3 % 2 is -1 in Java, so == 1 would miss it)
        System.out.println(countOdd(new int[]{}));                   // 0
        System.out.println(countOdd(new int[]{0}));                  // 0
    }
}
