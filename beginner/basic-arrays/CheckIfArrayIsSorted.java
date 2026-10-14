/** Check if the array is sorted (non-decreasing) - iterative. The recursive version is in basic-recursion */
public class CheckIfArrayIsSorted {

    // Compare each adjacent pair; the first descent means unsorted. O(n) time, O(1) space
    static boolean isSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) if (arr[i] < arr[i - 1]) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1, 2, 3, 4}));      // true
        System.out.println(isSorted(new int[]{1, 3, 2}));         // false
        System.out.println(isSorted(new int[]{2, 2, 2}));         // true   (equal neighbours are fine: non-decreasing)
        System.out.println(isSorted(new int[]{}));                // true
        System.out.println(isSorted(new int[]{5}));               // true
        System.out.println(isSorted(new int[]{5, 4}));            // false
    }
}
