import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/** Course Schedule (LC 207): prerequisites[i] = {course, prerequisite}. Can all courses be finished? (= the graph has NO cycle) */
public class CourseScheduleI {

    // Kahn's algorithm: if every course can be taken off the queue, there is no cycle. O(V + E) time, O(V + E) space
    static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);                                // edge: prerequisite -> course
            indeg[p[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.offer(i);
        int taken = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            taken++;
            for (int v : g.get(u)) if (--indeg[v] == 0) q.offer(v);
        }
        return taken == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));                          // true
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));                  // false (each needs the other)
        System.out.println(canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}}));          // true  (a chain)
        System.out.println(canFinish(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));          // false (3-cycle)
        System.out.println(canFinish(5, new int[][]{}));                                // true  (no prerequisites)
        System.out.println(canFinish(1, new int[][]{{0, 0}}));                          // false (a course requiring itself)
    }
}
