/** Linear Search - return index of target, or -1 */
public class LinearSearch {

    // O(n) time, O(1) space
    static int linearSearch(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(linearSearch(new int[]{6, 7, 8, 4, 1}, 4));   // 3
        System.out.println(linearSearch(new int[]{4, 5, 4}, 4));         // 0 (first occurrence)
        System.out.println(linearSearch(new int[]{1, 2, 3}, 9));         // -1
        System.out.println(linearSearch(new int[]{}, 1));                // -1
    }
}
