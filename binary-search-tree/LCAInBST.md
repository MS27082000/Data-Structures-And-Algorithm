# Lowest Common Ancestor in a BST (LC 235)

**Problem:** Find the lowest node that has both `p` and `q` as descendants (a node is a descendant of itself).

**General binary tree solution:** Post-order search of both subtrees → O(n) ([LCA in a Binary Tree](../tree-dfs/LowestCommonAncestor.md)).
**Using the BST property (O(h), O(1) space):** Start at the root.
- If **both** `p` and `q` are **smaller** than the node → go **left**.
- If **both** are **larger** → go **right**.
- Otherwise, the node is the **split point** (or equals one of them) → **it is the LCA**.

**Intuition:** While both keys are on the same side, the LCA must be on that side too. The first node that separates them is their lowest common ancestor.

**Complexity:** Time O(h), Space O(1) iterative.

**Edge cases:** `p` is an ancestor of `q` (answer is `p`), `p` equals `q`, the LCA is the root, a skewed tree.

**Interview traps**
- Mention that a BST gives **O(h)**, better than the O(n) general approach. That's the point of the question.
- Equality case: if `node.val == p` or `== q`, stop. The node is the answer.
- Assumes both keys exist in the tree. Otherwise add an existence check.

**How to explain:** "I walk down from the root. As long as both values are on the same side I follow that side; the first node where they split, or that equals one of them, is the lowest common ancestor."
