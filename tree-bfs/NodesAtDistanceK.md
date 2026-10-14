# All Nodes at Distance K from a Target Node (LC 863)

**Problem:** A binary tree, a target node, and `k`. Return all nodes at distance `k` from the target, where distance counts **edges in any direction** (down to children **or up to the parent**).

**Brute force:** For every node compute its distance to the target (via LCA/paths) → O(n²).
**Optimal:**
1. **Record every node's parent** (BFS/DFS from the root). This turns the tree into an **undirected graph** (left, right, parent).
2. **BFS from the target** for `k` levels using a **visited set** (so we don't go back).
3. The nodes left in the queue after `k` levels are exactly the answer → O(n), O(n).

**Intuition:** A tree's edges only point downwards, but distance is symmetric. Parent pointers let the search move up, so "tree" becomes "graph".

**Complexity:** Time O(n), Space O(n).

**Edge cases:** `k = 0` (just the target), `k` larger than the tree's reach (empty), target is the root, a single-node tree.

**Interview traps**
- **Visited set is mandatory.** Without it BFS bounces between a node and its parent.
- Stop after exactly `k` levels. Don't keep expanding.
- Compare nodes by **reference**, not value (values may repeat).
- The same technique solves **Minimum Time to Burn a Tree**.

**How to explain:** "I store each node's parent so I can move upward as well as downward, then run BFS from the target for k levels with a visited set. The nodes in the queue at that point are exactly distance k away."
