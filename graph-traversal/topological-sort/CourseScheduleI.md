# Course Schedule I (LC 207)

**Problem:** `numCourses` courses; `prerequisites[i] = {a, b}` means you must take `b` before `a`. Can you finish **all** courses?

**Approach:** Model prerequisites as a **directed graph** (`b → a`). You can finish everything **iff the graph has no cycle**. Use **Kahn's algorithm**: repeatedly take courses with in-degree 0; if you can take all `numCourses` of them, return `true` → **O(V + E)**.
**Alternative:** DFS cycle detection with the three-state array ([Directed Cycle](../dfs/CycleDetectionDirected.md)).

**Intuition:** A cycle of prerequisites (`A` needs `B`, `B` needs `A`) is a deadlock. Anything not on or behind a cycle can eventually be scheduled.

**Complexity:** Time O(V + E), Space O(V + E).

**Edge cases:** No prerequisites (true), a self-requirement (`{0, 0}`, false), a long chain (true), a cycle in only part of the graph (false).

**Interview traps**
- **Edge direction:** `{a, b}` means `b → a` (prerequisite points to the course). Reversing it also works for cycle detection but not for building an order.
- Count the removed nodes and compare with `numCourses`.
- Isolated courses (no edges) are free and count too.

**How to explain:** "I treat each prerequisite as a directed edge and run Kahn's algorithm. If I can remove all courses by repeatedly taking those with no unmet prerequisites there's no cycle, so the answer is true."
