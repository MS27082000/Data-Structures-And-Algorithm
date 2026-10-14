# Right / Left View of a Binary Tree (LC 199)

**Problem:** The nodes visible when you stand on the **right** (or **left**) side of the tree: one node per level.

**Approach 1 (BFS):** Level-order traversal. The **last** node of each level is the right view; the **first** node of each level is the left view → O(n), O(w).
**Approach 2 (DFS):** Traverse **right child first** (for the right view) with a `depth` parameter. The **first node reached at each new depth** is visible, so add it when `depth == list.size()` → O(n), O(h). For the left view traverse left first.

**Intuition:** Along each level the rightmost node hides every other node from the right side.

**Complexity:** BFS: Time O(n), Space O(w). DFS: Time O(n), Space O(h).

**Edge cases:** Empty tree, a left-leaning tree where the right view still shows left nodes at deeper levels (`[1,2,3,4]` → right view `[1,3,4]`), single node.

**Interview traps**
- The right view is **not** just the right-child chain. A deeper left node can be visible when the right side ends.
- In the DFS version the check is `depth == result.size()`, which means "first time we reach this depth".
- The root-to-rightmost-leaf walk is a common wrong answer.

**How to explain:** "At each level, the rightmost node is the visible one. With BFS I record the last node of every level; with DFS I visit the right subtree first and record the first node I see at each depth."
