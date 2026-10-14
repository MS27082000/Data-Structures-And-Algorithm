/** Second Largest Element (strictly smaller than the largest), -1 if it doesn't exist */
public class SecondLargestElement {

    // Single pass, O(n) time, O(1) space
    static int secondLargest(int[] a) {
        long largest = Long.MIN_VALUE, second = Long.MIN_VALUE;
        for (int x : a) {
            if (x > largest) {
                second = largest;
                largest = x;
            } else if (x < largest && x > second) {   // x != largest keeps it strict
                second = x;
            }
        }
        return second == Long.MIN_VALUE ? -1 : (int) second;
    }

    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{12, 35, 1, 10, 34, 1}));  // 34
        System.out.println(secondLargest(new int[]{10, 10, 10}));            // -1
        System.out.println(secondLargest(new int[]{5}));                     // -1
        System.out.println(secondLargest(new int[]{-1, -5, -3}));            // -3
        System.out.println(secondLargest(new int[]{10, 5, 10}));             // 5
    }
}
