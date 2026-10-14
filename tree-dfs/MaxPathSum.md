# Binary Tree Maximum Path Sum (LC 124)

**Problem:** A **path** is any sequence of connected nodes (each used at most once); it doesn't have to touch the root. Return the **maximum sum** of node values over all paths. Values can be negative.

**Brute force:** Try every pair of nodes → O(n²) or worse.
**Optimal:** Postorder DFS with a helper `gain(node)` = the best sum of a path that **starts at `node` and goes down one side**.
- `left = max(0, gain(left))`, `right = max(0, gain(right))` (drop a negative branch).
- **Best path bending at this node:** `node.val + left + right`, so update the global answer.
- **Return to the parent:** `node.val + max(left, right)`. A parent can extend **only one** side.
→ O(n).

**Intuition:** Each path has a topmost node. Two different quantities exist: what the path **through** a node can be (uses both sides) and what the node can **offer upward** (only one side).

**Complexity:** Time O(n), Space O(h).

**Edge cases:** **All negative values** (answer is the largest single node), a single node, a negative root between two big branches.

**Interview traps**
- Initialise the global answer to **`Integer.MIN_VALUE`**, not 0, or all-negative trees return 0 (wrong).
- **Clamp negative gains to 0** (`Math.max(0, ...)`).
- Return one side only, but update the global with both sides.
- Same pattern as Diameter (sums instead of lengths).

**How to explain:** "For every node I compute the best downward path I can offer my parent (one branch only), and separately update the global maximum with the best path that turns at this node (both branches), ignoring branches that would reduce the sum."
