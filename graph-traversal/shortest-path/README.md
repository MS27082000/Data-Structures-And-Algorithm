# Shortest Path Algorithms

Source: Striver's A2Z DSA Sheet, Graphs → Shortest Path Algorithms (12 items). Active recall: open the link, solve from scratch, then check the notes.

## Which algorithm?
| Situation | Use | Time |
|---|---|---|
| All edges equal | **BFS** | O(V + E) |
| Edges 0 or 1 | 0-1 BFS (deque) | O(V + E) |
| **Non-negative** weights, one source | **Dijkstra** | O((V + E) log V) |
| **Negative** weights allowed / negative cycle check | **Bellman-Ford** | O(V·E) |
| At most K edges | Bellman-Ford limited to K rounds | O(K·E) |
| **All pairs** | **Floyd-Warshall** | O(V³) |
| DAG | Relax in topological order | O(V + E) |

## Dijkstra template
```java
int[] dist = new int[n]; Arrays.fill(dist, INF); dist[src] = 0;
PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
pq.offer(new int[]{0, src});
while (!pq.isEmpty()) {
    int[] cur = pq.poll(); int d = cur[0], u = cur[1];
    if (d > dist[u]) continue;                       // stale entry
    for (int[] e : adj.get(u)) if (d + e[1] < dist[e[0]]) { dist[e[0]] = d + e[1]; pq.offer(new int[]{dist[e[0]], e[0]}); }
}
```
**Variations:** path cost can be a **max** (min effort, swim in water) or a **count** of paths (ways to arrive) as long as the greedy order still holds.

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Dijkstra's Algorithm](DijkstraAlgorithm.md) | [GfG](https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1) | Min-heap greedy | O((V+E) log V) |
| 2 | [Print Shortest Path](PrintShortestPath.md) | [GfG](https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1) | Dijkstra + parent array | O((V+E) log V) |
| 3 | [Shortest Distance in a Binary Maze](ShortestDistanceBinaryMaze.md) | [GfG](https://www.geeksforgeeks.org/problems/shortest-path-in-a-binary-maze-1655453161/1) | BFS on the grid | O(R·C) |
| 4 | [Path With Minimum Effort](PathWithMinimumEffort.md) | [LC 1631](https://leetcode.com/problems/path-with-minimum-effort/) | Dijkstra with `max` | O(RC log RC) |
| 5 | [Cheapest Flights Within K Stops](CheapestFlightsWithinKStops.md) | [LC 787](https://leetcode.com/problems/cheapest-flights-within-k-stops/) | Bellman-Ford, K+1 rounds | O(K·E) |
| 6 | [Minimum Multiplications to Reach End](MinimumMultiplications.md) | [GfG](https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1) | BFS over residues | O(1e5·n) |
| 7 | [Number of Ways to Arrive at Destination](NumberOfWaysToArriveAtDestination.md) | [LC 1976](https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/) | Dijkstra + path counts | O((V+E) log V) |
| 8 | [Bellman-Ford Algorithm](BellmanFord.md) | [GfG](https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1) | V−1 relaxations + cycle check | O(V·E) |
| 9 | [Floyd-Warshall Algorithm](FloydWarshall.md) | [GfG](https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1) | DP over intermediates | O(V³) |
| 10 | [City with the Smallest Number of Neighbours](CityWithSmallestNumberOfNeighbors.md) | [LC 1334](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/) | Floyd-Warshall + count | O(V³) |
| 11 | [Network Delay Time](NetworkDelayTime.md) | [LC 743](https://leetcode.com/problems/network-delay-time/) | Dijkstra, take the max | O((V+E) log V) |
| 12 | [Swim in Rising Water](SwimInRisingWater.md) | [LC 778](https://leetcode.com/problems/swim-in-rising-water/) | Dijkstra with `max` | O(n² log n) |

## Run any program
```
javac -d out *.java
java -cp out DijkstraAlgorithm
```
