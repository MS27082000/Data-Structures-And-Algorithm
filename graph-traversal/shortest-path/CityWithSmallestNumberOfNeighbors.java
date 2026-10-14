import java.util.Arrays;

/** Find the City With the Smallest Number of Neighbours at a Threshold Distance (LC 1334): among cities, the one that can reach the FEWEST other
 *  cities with a shortest-path distance <= distanceThreshold. Ties: return the city with the GREATEST number. */
public class CityWithSmallestNumberOfNeighbors {

    // All-pairs shortest paths with Floyd-Warshall, then count for each city how many others are within the threshold.
    // O(V^3) time, O(V^2) space
    static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = 1_000_000_000;
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, INF);
        for (int i = 0; i < n; i++) dist[i][i] = 0;
        for (int[] e : edges) {                                    // undirected: set both directions
            dist[e[0]][e[1]] = e[2];
            dist[e[1]][e[0]] = e[2];
        }
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j]) dist[i][j] = dist[i][k] + dist[k][j];

        int best = -1, bestCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) if (i != j && dist[i][j] <= distanceThreshold) count++;
            if (count <= bestCount) {                              // <= so a LATER (greater-numbered) city wins ties
                bestCount = count;
                best = i;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));                              // 3
        System.out.println(findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));        // 0
        System.out.println(findTheCity(2, new int[][]{}, 1));                                                                        // 1  (nobody reaches anyone; tie -> the greater index)
        System.out.println(findTheCity(3, new int[][]{{0, 1, 1}, {1, 2, 1}}, 5));                                                    // 2  (everyone reaches 2 others; tie -> greatest)
    }
}
