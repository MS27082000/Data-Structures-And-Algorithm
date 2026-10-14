# Bottom View of a Binary Tree

**Problem:** The nodes visible from below, listed from left to right.

**Approach:** Identical to [Top View](TopView.md), except you **overwrite**: for each column keep the **last** node reached in BFS (deepest, and the later one at the same level). Output the columns in sorted order → O(n log n).

**Intuition:** Looking up from the bottom, the deepest node in a column hides everything above it. BFS reaches deeper nodes later, so the last write wins.

**Complexity:** Time O(n log n), Space O(n).

**Edge cases:** Skewed trees, a single node, two nodes in the same column **and the same level** (the one that comes later in left-to-right order wins, which depends on the problem's convention).

**Interview traps**
- **Overwrite (`put`)**, not `putIfAbsent`. This is the only difference from Top View.
- Ties on the same row and column: GfG's expected answer takes the **rightmost** node of that level (BFS processes left to right, so the later one overwrites). Check the statement.
- Use BFS so that "last" means "deepest".

**How to explain:** "Same as the top view but I keep updating the value for each column, so the last node seen, which is the deepest, is the one visible from the bottom."
