# Number of Operations to Make Network Connected (LC 1319)

**Problem:** `n` computers `0..n−1` and a list of cables between pairs. In one operation you can take a cable from a **redundant** place and use it to connect two unconnected computers. Return the **minimum operations** to connect all computers, or `-1` if impossible.

**Key insights**
1. Connecting `n` nodes needs at least **`n − 1`** cables. If `connections.length < n − 1` → `-1`.
2. Otherwise the answer is simply **`components − 1`**: every extra component needs one link, and there are enough spare cables.

**Approach:** Use a [Disjoint Set](DisjointSet.md). Union every cable; count the components (decrement when a union succeeds). Return `components − 1` (after the cable-count check) → **O(n + E·α)**.

**Intuition:** A cable that joins two nodes already in the same component is a **spare**. Because we have at least `n − 1` cables there are always enough spares to reach the remaining components.

**Complexity:** Time O(n + E α(n)), Space O(n).

**Edge cases:** Fewer than `n − 1` cables (-1), already connected (0), isolated computers, many redundant cables, `n = 1`.

**Interview traps**
- **Do the `n − 1` check first.** Without enough cables no rearrangement helps.
- You don't need to count spare cables explicitly. The `n − 1` bound guarantees them.
- Components, not edges, determine the count.
- Works equally with DFS to count components.

**How to explain:** "I need at least n − 1 cables, otherwise it's impossible. If I have enough, I count the connected components with union-find; each component beyond the first needs exactly one move, so the answer is components − 1."
