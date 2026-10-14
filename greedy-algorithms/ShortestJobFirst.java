import java.util.Arrays;

/** Shortest Job First (non-preemptive, all jobs arrive at time 0): minimise the AVERAGE waiting time */
public class ShortestJobFirst {

    // Sort burst times ascending; each job waits for the sum of all jobs before it. Return floor(average wait).
    // O(n log n) time, O(1) extra space. long: the total wait can exceed int range
    static long averageWaitingTime(int[] burst) {
        if (burst.length == 0) return 0;
        int[] jobs = burst.clone();
        Arrays.sort(jobs);
        long totalWait = 0, elapsed = 0;
        for (int job : jobs) {
            totalWait += elapsed;                  // this job waited `elapsed` time units
            elapsed += job;
        }
        return totalWait / jobs.length;
    }

    public static void main(String[] args) {
        System.out.println(averageWaitingTime(new int[]{4, 3, 7, 1, 2}));   // 4   (order 1,2,3,4,7: waits 0,1,3,6,10 = 20 / 5)
        System.out.println(averageWaitingTime(new int[]{1, 2, 3, 4}));      // 2   (waits 0,1,3,6 = 10 / 4 = 2.5 -> 2)
        System.out.println(averageWaitingTime(new int[]{5}));               // 0
        System.out.println(averageWaitingTime(new int[]{}));                // 0
        System.out.println(averageWaitingTime(new int[]{6, 8, 7, 3}));      // 7   (3,6,7,8: waits 0,3,9,16 = 28 / 4 = 7)
    }
}
