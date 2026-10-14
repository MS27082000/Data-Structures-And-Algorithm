import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.PriorityQueue;

/** Task Scheduler (LC 621): run all tasks (one per unit time, A-Z); the SAME task needs a gap of at least n units between runs.
 *  Return the minimum total time (idle units count). */
public class TaskScheduler {

    // Greedy formula: the most frequent task forces (maxFreq - 1) full "frames" of length n + 1, plus a last partial frame holding
    // every task that ties for the maximum. The answer can never be below the number of tasks. O(m) time, O(1) space
    static int leastIntervalFormula(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (char c : tasks) maxFreq = Math.max(maxFreq, ++freq[c - 'A']);
        int tied = 0;
        for (int f : freq) if (f == maxFreq) tied++;
        return Math.max(tasks.length, (maxFreq - 1) * (n + 1) + tied);
    }

    // Simulation with a max-heap of remaining counts + a cooldown queue. Each tick run the task with the most remaining runs;
    // it re-enters the heap after its cooldown. O(m log 26) time
    static int leastIntervalHeap(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) freq[c - 'A']++;
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) if (f > 0) heap.offer(f);
        Deque<int[]> cooldown = new ArrayDeque<>();                  // {remaining count, time when it becomes available}
        int time = 0;
        while (!heap.isEmpty() || !cooldown.isEmpty()) {
            time++;
            if (!heap.isEmpty()) {
                int remaining = heap.poll() - 1;
                if (remaining > 0) cooldown.offer(new int[]{remaining, time + n});
            }                                                        // else: idle tick
            if (!cooldown.isEmpty() && cooldown.peek()[1] == time) heap.offer(cooldown.poll()[0]);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] a = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(leastIntervalFormula(a, 2) + " " + leastIntervalHeap(a, 2));      // 8 8   (A B idle A B idle A B)
        System.out.println(leastIntervalFormula(a, 0) + " " + leastIntervalHeap(a, 0));      // 6 6
        char[] b = {'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        System.out.println(leastIntervalFormula(b, 2) + " " + leastIntervalHeap(b, 2));      // 16 16
        char[] c = {'A', 'B', 'C', 'D', 'A', 'B', 'C', 'D'};
        System.out.println(leastIntervalFormula(c, 1) + " " + leastIntervalHeap(c, 1));      // 8 8  (no idle time needed)
        System.out.println(leastIntervalFormula(new char[]{'A'}, 5));                        // 1
    }
}
