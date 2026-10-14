/** Sum of array elements (recursive) */
public class SumOfArrayElementsII {

    // sum(i) = arr[i] + sum(i + 1); base: past the end -> 0. O(n) time, O(n) stack
    static long sum(int[] arr, int i) {
        if (i == arr.length) return 0;
        return arr[i] + sum(arr, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4}, 0));     // 10
        System.out.println(sum(new int[]{}, 0));                // 0
        System.out.println(sum(new int[]{-1, 1}, 0));           // 0
        System.out.println(sum(new int[]{5}, 0));               // 5
    }
}
