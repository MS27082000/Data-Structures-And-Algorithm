import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/** Course Schedule II (LC 210): return an order in which the courses can be taken, or an empty array if impossible */
public class CourseScheduleII {

    // Same Kahn's algorithm as Course Schedule I, but KEEP the order of removal. O(V + E) time, O(V + E) space
    static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        int[] indeg = new int[numCourses];
        for (int[] p : prerequisites) {
            g.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.offer(i);
        int[] order = new int[numCourses];
        int count = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            order[count++] = u;
            for (int v : g.get(u)) if (--indeg[v] == 0) q.offer(v);
        }
        return count == numCourses ? order : new int[0];
    }

    static boolean valid(int n, int[][] prereq, int[] order) {
        if (order.length != n) return false;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[order[i]] = i;
        for (int[] p : prereq) if (pos[p[1]] >= pos[p[0]]) return false;
        return true;
    }

    public static void main(String[] args) {
        int[][] pre = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] order = findOrder(4, pre);
        System.out.println(Arrays.toString(order) + " " + valid(4, pre, order));      // [0, 1, 2, 3] true  ([0, 2, 1, 3] is also valid)
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}})));        // [0, 1]
        System.out.println(Arrays.toString(findOrder(2, new int[][]{{1, 0}, {0, 1}}))); // []  (cycle)
        System.out.println(Arrays.toString(findOrder(1, new int[][]{})));               // [0]
        System.out.println(Arrays.toString(findOrder(3, new int[][]{})));               // [0, 1, 2]
    }
}
