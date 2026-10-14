# Maximum Depth of a Binary Tree (LC 104)

**Problem:** The number of nodes along the longest path from the root to a leaf.

**Recursive (DFS):** `maxDepth(node) = 1 + max(maxDepth(left), maxDepth(right))`, with `maxDepth(null) = 0` → O(n) time, O(h) stack.
**Iterative (BFS):** Level-order traversal, counting the number of levels → O(n) time, O(w) space.

**Intuition:** The depth of a tree is one more than the deeper of its two subtrees.

**Complexity:** Time O(n), Space O(h) (DFS) or O(w) (BFS).

**Edge cases:** Empty tree (0), a single node (1), a skewed tree (depth = n).

**Interview traps**
- Clarify **nodes vs edges**: this problem counts **nodes** (empty = 0, single node = 1).
- A skewed tree of 10⁵ nodes can overflow the recursion stack. Mention the BFS version.
- This is the base recursion pattern for height-based problems: **Balanced Tree, Diameter, Max Path Sum**.
- Minimum depth is trickier: a node with one child is **not** a leaf, so you can't just take `min(left, right)`.

**How to explain:** "The depth of a node is one plus the larger of its children's depths, and an empty tree has depth zero. So I recurse on both children and combine."
