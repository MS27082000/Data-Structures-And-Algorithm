# Dijkstra's Algorithm

**Problem:** Single-source shortest paths in a weighted graph with **non-negative** edge weights.

**Approach (greedy):** Keep `dist[]` (initially ∞, `dist[src] = 0`) and a **min-heap** of `{distance, node}`. Repeatedly **pop the closest unfinished node** `u`; for each edge `u → v` with weight `w`, if `dist[u] + w < dist[v]`, update `dist[v]` and push `{dist[v], v}`. A popped node's distance is **final** → **O((V + E) log V)**.

**Why greedy is correct:** With non-negative weights, any other route to the closest unfinished node would have to pass through a node at least as far, so it can't be shorter.

**Lazy deletion:** Java's `PriorityQueue` has no decrease-key. Push a **new** entry and **skip stale entries** when popped (`if (d > dist[u]) continue;`).

**Complexity:** Time O((V + E) log V), Space O(V + E). (Array-based version: O(V²).)

**Edge cases:** Unreachable nodes, parallel edges (take the minimum), a single node, zero-weight edges (fine), disconnected graph.

**Interview traps**
- **Negative edges break it.** Use [Bellman-Ford](BellmanFord.md). Know why: a finalised node could still be improved through a negative edge.
- Skip stale heap entries, or the complexity degrades and results can be wrong.
- Avoid `INF + w` overflow: only relax from finite distances.
- To recover the path, store a `parent` ([Print Shortest Path](PrintShortestPath.md)).
- Dijkstra with a **different path cost** (max edge, product of probabilities, etc.) also works if the cost is monotone: see [Min Effort](PathWithMinimumEffort.md).

**How to explain:** "I always expand the unfinished node with the smallest known distance, using a min-heap, and relax its edges. Because weights are non-negative, that distance can't be improved later, so each node is finalised once. It runs in O((V + E) log V)."
