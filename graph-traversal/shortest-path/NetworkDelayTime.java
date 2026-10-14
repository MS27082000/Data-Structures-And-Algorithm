import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/** Network Delay Time (LC 743): a signal is sent from node k. times[i] = {u, v, w} (directed, nodes 1..n). Time for ALL nodes to receive it, or -1 */
public class NetworkDelayTime {

    // Dijkstra from k; the answer is the LARGEST shortest distance (the last node to be reached). Any unreachable node => -1.
    // O((V + E) log V) time, O(V + E) space
    static int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> g = new ArrayList<>();
        for (int i = 0; i <= n; i++) g.add(new ArrayList<>());
        for (int[] t : times) g.get(t[0]).add(new int[]{t[1], t[2]});
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, k});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (cur[0] > dist[cur[1]]) continue;
            for (int[] e : g.get(cur[1])) {
                if (cur[0] + e[1] < dist[e[0]]) {
                    dist[e[0]] = cur[0] + e[1];
                    pq.offer(new int[]{dist[e[0]], e[0]});
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == INF) return -1;                         // someone never receives the signal
            max = Math.max(max, dist[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(networkDelayTime(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2));     // 2
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}}, 2, 1));                           // 1
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}}, 2, 2));                           // -1  (2 cannot reach 1)
        System.out.println(networkDelayTime(new int[][]{}, 1, 1));                                    // 0   (a single node)
        System.out.println(networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 4}}, 3, 1));     // 3   (3 via 2 costs 3 < 4)
    }
}
