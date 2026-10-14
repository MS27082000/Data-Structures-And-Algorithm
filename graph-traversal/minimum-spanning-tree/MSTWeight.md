# Find the MST Weight (Kruskal's Algorithm)

**Problem:** Return the total weight of a Minimum Spanning Tree of a connected weighted undirected graph.

**Kruskal's algorithm (grow a forest):**
1. **Sort all edges** by weight.
2. Go through them lightest first. Keep an edge if its two endpoints are in **different components** (checked with a [Disjoint Set](../union-find/DisjointSet.md)); then **union** them. Otherwise skip it (it would form a cycle).
3. Stop after `V − 1` edges.
→ **O(E log E)** (dominated by the sort), nearly linear in the union-find part.

**Intuition:** The cycle property says the heaviest edge of any cycle can be discarded, so taking the lightest edge that doesn't close a cycle is always safe.

**Complexity:** Time O(E log E), Space O(V).

**Prim vs Kruskal**
| | Prim | Kruskal |
|---|---|---|
| Input | Adjacency list | Edge list |
| Grows | One tree | A forest that merges |
| Data structure | Min-heap | Sort + Disjoint Set |
| Better for | Dense graphs | Sparse graphs |

**Edge cases:** Disconnected graph (fewer than `V − 1` edges chosen → `-1`), a single node (0), equal weights, parallel edges.

**Interview traps**
- The **Disjoint Set with path compression + union by size** is what makes the cycle check fast.
- Don't forget to stop at `V − 1` edges (or you'll scan unneeded edges).
- Check connectivity: if you used fewer than `V − 1` edges the graph was disconnected.
- Use **`long`** for the total if weights are large.

**How to explain:** "I sort the edges and add them from the lightest, skipping any edge whose endpoints are already connected, which I test with union-find. After V − 1 edges I have the minimum spanning tree and its weight."
