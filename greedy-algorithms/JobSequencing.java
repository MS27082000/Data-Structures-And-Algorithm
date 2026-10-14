import java.util.Arrays;

/** Job Sequencing: each job takes 1 unit of time, has a deadline and a profit. Maximise the total profit.
 *  Returns {number of jobs done, maximum profit}. */
public class JobSequencing {

    // Sort jobs by profit (descending). For each job take the LATEST free slot <= its deadline. O(n log n + n * maxDeadline)
    static int[] jobSequencing(int[] deadline, int[] profit) {
        int n = deadline.length, maxDeadline = 0;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
            maxDeadline = Math.max(maxDeadline, deadline[i]);
        }
        Arrays.sort(order, (a, b) -> profit[b] - profit[a]);

        boolean[] slotTaken = new boolean[maxDeadline + 1];        // slots 1..maxDeadline
        int jobs = 0, total = 0;
        for (int idx : order) {
            for (int slot = Math.min(deadline[idx], maxDeadline); slot >= 1; slot--) {
                if (!slotTaken[slot]) {                            // latest free slot keeps earlier slots open for others
                    slotTaken[slot] = true;
                    jobs++;
                    total += profit[idx];
                    break;
                }
            }
        }
        return new int[]{jobs, total};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(jobSequencing(new int[]{4, 1, 1, 1}, new int[]{20, 10, 40, 30})));          // [2, 60]
        System.out.println(Arrays.toString(jobSequencing(new int[]{2, 1, 2, 1, 1}, new int[]{100, 19, 27, 25, 15}))); // [2, 127]
        System.out.println(Arrays.toString(jobSequencing(new int[]{3, 3, 3}, new int[]{5, 10, 15})));                  // [3, 30]
        System.out.println(Arrays.toString(jobSequencing(new int[]{1, 1}, new int[]{7, 9})));                          // [1, 9]
        System.out.println(Arrays.toString(jobSequencing(new int[]{}, new int[]{})));                                  // [0, 0]
    }
}
