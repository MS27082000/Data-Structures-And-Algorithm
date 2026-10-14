/** Check if the array is sorted (recursive) */
public class CheckIfArrayIsSortedII {

    // arr[i-1] <= arr[i] and the rest is sorted. Base: a single element (or empty) is sorted. O(n) time, O(n) stack
    static boolean isSorted(int[] arr, int i) {
        if (i >= arr.length - 1) return true;
        if (arr[i] > arr[i + 1]) return false;
        return isSorted(arr, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{1, 2, 3}, 0));     // true
        System.out.println(isSorted(new int[]{1, 3, 2}, 0));     // false
        System.out.println(isSorted(new int[]{2, 2}, 0));        // true
        System.out.println(isSorted(new int[]{}, 0));            // true
        System.out.println(isSorted(new int[]{9}, 0));           // true
    }
}
