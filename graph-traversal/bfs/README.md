# Graph BFS (Shortest Paths with Unit Weights, Multi-Source)

Source: Striver's A2Z DSA Sheet, Graphs → Traversal Problems and Hard Problems. Active recall: open the link, solve from scratch, then check the notes.

## When to use BFS on a graph / grid
- **Shortest path when every edge costs the same** (number of steps, moves, transformations)
- **Spreading simultaneously** from many sources (rotten oranges, nearest 1) → **multi-source BFS**
- Level-by-level processing

## Templates
```java
// shortest distance from src (unit weights)
int[] dist = new int[n]; Arrays.fill(dist, -1);
Queue<Integer> q = new ArrayDeque<>(); q.offer(src); dist[src] = 0;
while (!q.isEmpty()) { int u = q.poll(); for (int v : adj.get(u)) if (dist[v] == -1) { dist[v] = dist[u] + 1; q.offer(v); } }

// multi-source: offer ALL sources first, then run the same loop
```
Level-by-level loop: `for (int i = q.size(); i > 0; i--) { ... }` inside the `while`.

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Rotten Oranges](RottenOranges.md) | [LC 994](https://leetcode.com/problems/rotting-oranges/) | Multi-source BFS, level = minute | O(R·C) |
| 2 | [Distance of Nearest Cell having 1](NearestCellHavingOne.md) | [LC 542](https://leetcode.com/problems/01-matrix/) | Multi-source BFS from the targets | O(R·C) |
| 3 | [Shortest Path in Undirected Graph, Unit Weights](ShortestPathUnitWeights.md) | [GfG](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1) | BFS distances | O(V + E) |
| 4 | [Word Ladder I](WordLadderI.md) | [LC 127](https://leetcode.com/problems/word-ladder/) | BFS over one-letter variants | O(N·L·26) |
| 5 | [Word Ladder II](WordLadderII.md) | [LC 126](https://leetcode.com/problems/word-ladder-ii/) | BFS + parents + DFS backtrack | O(N·L·26 + output) |

## BFS vs Dijkstra vs 0-1 BFS
| Edge weights | Algorithm |
|---|---|
| All equal | **BFS** |
| 0 or 1 | 0-1 BFS (deque) |
| Non-negative | [Dijkstra](../shortest-path/DijkstraAlgorithm.md) |
| Negative | [Bellman-Ford](../shortest-path/BellmanFord.md) |

## Run any program
```
javac -d out *.java
java -cp out RottenOranges
```
