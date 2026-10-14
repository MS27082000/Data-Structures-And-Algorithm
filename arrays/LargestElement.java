/** Largest Element in an Array */
public class LargestElement {

    // O(n) time, O(1) space. Start from a[0], NOT 0 (breaks for all-negative arrays)
    static int largest(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(largest(new int[]{3, 2, 1, 5, 2}));   // 5
        System.out.println(largest(new int[]{-8, -3, -10}));     // -3
        System.out.println(largest(new int[]{7}));               // 7
    }
}
