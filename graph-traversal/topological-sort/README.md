# Topological Sort

Source: Striver's A2Z DSA Sheet, Graphs → Cycles and Hard Problems. Active recall: open the link, solve from scratch, then check the notes.

## When to use
Dependencies, ordering, prerequisites, "can everything be scheduled?", detecting cycles in a **directed** graph, DP on a DAG.

## Kahn's algorithm (the template)
```java
int[] indeg = new int[n];                       // count incoming edges
Queue<Integer> q = new ArrayDeque<>();
for (int i = 0; i < n; i++) if (indeg[i] == 0) q.offer(i);
int taken = 0;
while (!q.isEmpty()) {
    int u = q.poll(); taken++;                  // u goes next in the order
    for (int v : adj.get(u)) if (--indeg[v] == 0) q.offer(v);
}
boolean hasCycle = (taken < n);
```
**Rules:** only DAGs have a topological order · the order is not unique · `taken < n` means a cycle.

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Topological Sort / Kahn's Algorithm](TopologicalSortKahn.md) | [GfG](https://www.geeksforgeeks.org/problems/topological-sort/1) | In-degree BFS, or DFS finish order | O(V + E) |
| 2 | [Course Schedule I](CourseScheduleI.md) | [LC 207](https://leetcode.com/problems/course-schedule/) | No cycle ⇔ all taken | O(V + E) |
| 3 | [Course Schedule II](CourseScheduleII.md) | [LC 210](https://leetcode.com/problems/course-schedule-ii/) | Output Kahn's order | O(V + E) |
| 4 | [Alien Dictionary](AlienDictionary.md) | [LC 269](https://leetcode.com/problems/alien-dictionary/) (premium) | Letter edges from adjacent words, then Kahn | O(C) |
| 5 | [Find Eventual Safe States](EventualSafeStates.md) | [LC 802](https://leetcode.com/problems/find-eventual-safe-states/) | Kahn on the reversed graph | O(V + E) |
| 6 | [Shortest Path in a DAG](ShortestPathInDAG.md) | [GfG](https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1) | Relax in topological order | O(V + E) |

(Detecting cycles with DFS: [dfs/CycleDetectionDirected](../dfs/CycleDetectionDirected.md).)

## Run any program
```
javac -d out *.java
java -cp out CourseScheduleII
```
