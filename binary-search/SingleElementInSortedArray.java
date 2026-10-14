/** Single Element in a Sorted Array (LC 540): every element appears twice except one. O(log n) required */
public class SingleElementInSortedArray {

    // Before the single element pairs start at EVEN indices; after it they start at ODD indices.
    // Force mid to be even, then check whether its partner is on the right. O(log n), O(1)
    static int singleNonDuplicate(int[] a) {
        int low = 0, high = a.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 1) mid--;                  // make mid even
            if (a[mid] == a[mid + 1]) low = mid + 2;  // pair intact => single is on the right
            else high = mid;                          // pair broken => single is at mid or on the left
        }
        return a[low];
    }

    public static void main(String[] args) {
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}));   // 2
        System.out.println(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}));      // 10
        System.out.println(singleNonDuplicate(new int[]{1}));                           // 1
        System.out.println(singleNonDuplicate(new int[]{1, 2, 2}));                     // 1
        System.out.println(singleNonDuplicate(new int[]{1, 1, 2}));                     // 2
    }
}
