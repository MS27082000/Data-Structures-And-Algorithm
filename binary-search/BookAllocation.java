/** Book Allocation: allocate n books (contiguous) to m students; minimise the MAXIMUM pages given to any student */
public class BookAllocation {

    // Binary search on the max pages in [max(pages), sum(pages)]. O(n log sum), O(1)
    static int findPages(int[] pages, int m) {
        if (m > pages.length) return -1;               // each student needs at least one book
        int low = 0, high = 0;
        for (int p : pages) {
            low = Math.max(low, p);
            high += p;
        }
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (studentsNeeded(pages, mid) <= m) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    private static int studentsNeeded(int[] pages, int limit) {
        int students = 1, load = 0;
        for (int p : pages) {
            if (load + p > limit) {
                students++;
                load = p;
            } else {
                load += p;
            }
        }
        return students;
    }

    public static void main(String[] args) {
        System.out.println(findPages(new int[]{25, 46, 28, 49, 24}, 4));   // 71
        System.out.println(findPages(new int[]{12, 34, 67, 90}, 2));       // 113
        System.out.println(findPages(new int[]{10, 20, 30}, 5));           // -1
        System.out.println(findPages(new int[]{10, 20, 30}, 1));           // 60
    }
}
