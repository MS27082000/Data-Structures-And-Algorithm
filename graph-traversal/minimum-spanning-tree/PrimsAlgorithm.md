# MST Theory and Prim's Algorithm

## What a Minimum Spanning Tree is
A **spanning tree** of a connected undirected graph is a subset of edges that connects **all `V` nodes with no cycle** (exactly `V − 1` edges). An **MST** is a spanning tree with the **minimum total edge weight**.
- Only **connected** graphs have a spanning tree; a disconnected graph has a spanning **forest**.
- If all edge weights are distinct, the MST is **unique**.

## Two key properties
- **Cut property:** For any split of the nodes into two groups, the **lightest edge crossing the split** belongs to some MST. (Why greedy works.)
- **Cycle property:** The **heaviest edge of any cycle** is not needed in an MST.

## Prim's algorithm (grow a single tree)
1. Start from any node and put it in the tree.
2. Keep a **min-heap** of edges leaving the tree.
3. Repeatedly pop the lightest edge that reaches a node **not yet in the tree**, add that node and its weight, and push the new node's edges.
4. After `V` nodes the tree is complete → **O(E log V)**.

**Intuition:** At every step the tree and the rest of the graph form a cut, so the lightest crossing edge is safe to take (cut property).

**Complexity:** Time O(E log V), Space O(V + E).

**Edge cases:** Disconnected graph (cannot reach all nodes → no MST, report `-1`), a single node (0), equal weights (several valid MSTs), parallel edges.

**Interview traps**
- **Skip edges leading to nodes already in the tree** when popped.
- Prim ≈ Dijkstra, but the heap key is the **edge weight**, not the distance from the source.
- Prim is good for **dense** graphs; [Kruskal](MSTWeight.md) is good for sparse graphs or an edge list.
- Don't confuse MST with shortest paths. The MST does **not** give shortest distances.

**How to explain:** "I grow one tree from a start node, always adding the cheapest edge that connects a new node to the tree. By the cut property each choice is safe, and I get the minimum total weight in O(E log V)."
