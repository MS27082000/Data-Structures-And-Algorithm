import java.util.Arrays;

/** N Meetings in One Room: maximum number of meetings that can be held (a meeting can start when the previous one has ended) */
public class NMeetingsInOneRoom {

    // Activity selection: sort meetings by END time; take a meeting if it starts AFTER the last chosen end.
    // O(n log n) time, O(n) space
    static int maxMeetings(int[] start, int[] end) {
        int n = start.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> end[a] != end[b] ? Integer.compare(end[a], end[b]) : Integer.compare(start[a], start[b]));

        int count = 0, lastEnd = Integer.MIN_VALUE;
        for (int idx : order) {
            if (start[idx] > lastEnd) {                // strictly after: the room must be free (GfG version)
                count++;
                lastEnd = end[idx];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}));   // 4
        System.out.println(maxMeetings(new int[]{10, 12, 20}, new int[]{20, 25, 30}));               // 1
        System.out.println(maxMeetings(new int[]{1, 2}, new int[]{2, 3}));                           // 1 (2 is not strictly after 2)
        System.out.println(maxMeetings(new int[]{0}, new int[]{5}));                                 // 1
        System.out.println(maxMeetings(new int[]{}, new int[]{}));                                   // 0
    }
}
