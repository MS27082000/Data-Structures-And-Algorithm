# Graph DFS (Grids, Components and Cycles)

Source: Striver's A2Z DSA Sheet, Graphs → Traversal Problems and Cycles. Active recall: open the link, solve from scratch, then check the notes.

## When to use DFS on a graph / grid
Connected components, flood fill, "region touches the border" questions, shape signatures, cycle detection, colouring.

## Grid template (the grid is an implicit graph)
```java
void dfs(int r, int c) {
    if (r < 0 || c < 0 || r >= R || c >= C || visited[r][c] || notLand) return;
    visited[r][c] = true;
    dfs(r + 1, c); dfs(r - 1, c); dfs(r, c + 1); dfs(r, c - 1);
}
```
**Border-first trick:** to find regions that are *not* connected to the border, flood-fill from the border and take what is left (Enclaves, Surrounded Regions).

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Number of Provinces](NumberOfProvinces.md) | [LC 547](https://leetcode.com/problems/number-of-provinces/) | Components on an adjacency matrix | O(V²) |
| 2 | [Number of Islands](NumberOfIslands.md) | [LC 200](https://leetcode.com/problems/number-of-islands/) | Flood-fill, count starts | O(R·C) |
| 3 | [Flood Fill](FloodFill.md) | [LC 733](https://leetcode.com/problems/flood-fill/) | Recolour a region (guard same colour) | O(R·C) |
| 4 | [Number of Enclaves](NumberOfEnclaves.md) | [LC 1020](https://leetcode.com/problems/number-of-enclaves/) | Sink border land first | O(R·C) |
| 5 | [Surrounded Regions](SurroundedRegions.md) | [LC 130](https://leetcode.com/problems/surrounded-regions/) | Protect border-connected 'O's | O(R·C) |
| 6 | [Number of Distinct Islands](NumberOfDistinctIslands.md) | [LC 694](https://leetcode.com/problems/number-of-distinct-islands/) (premium) | DFS path signature | O(R·C) |
| 7 | [Cycle in an Undirected Graph](CycleDetectionUndirected.md) | [GfG](https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1) | Visited neighbour ≠ parent | O(V + E) |
| 8 | [Bipartite Graph](BipartiteGraph.md) | [LC 785](https://leetcode.com/problems/is-graph-bipartite/) | 2-colouring | O(V + E) |
| 9 | [Cycle in a Directed Graph](CycleDetectionDirected.md) | [GfG](https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1) | 3-state DFS | O(V + E) |

(Rotten Oranges and Distance of Nearest 1 are BFS problems: see [bfs](../bfs/README.md). Topological Sort and the DAG problems: [topological-sort](../topological-sort/README.md).)

## Run any program
```
javac -d out *.java
java -cp out NumberOfIslands
```
