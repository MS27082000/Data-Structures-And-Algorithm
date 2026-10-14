# Lowest Common Ancestor in a Binary Tree (LC 236)

**Problem:** The **LCA** of nodes `p` and `q` is the **deepest** node that has both as descendants (a node counts as a descendant of itself).

**Brute force:** Find the root-to-`p` path and the root-to-`q` path (two DFS passes), then find the last common node → O(n) time, O(h) space.
**Optimal (one pass, postorder):** Recursively search both subtrees.
- If the current node is `null`, `p` or `q` → return it.
- `left = lca(left)`, `right = lca(right)`.
- **Both non-null** → `p` and `q` are in different subtrees, so **this node is the LCA**.
- Otherwise return whichever is non-null (the node found, or the LCA already found below).

**Intuition:** The first node (from the bottom) that has one target on each side is the meeting point. If one target is an ancestor of the other, the search returns the ancestor early, which is correct.

**Complexity:** Time O(n), Space O(h).

**Edge cases:** `p` is an ancestor of `q` (answer is `p`), `p == q`, the LCA is the root, both nodes in one subtree.

**Interview traps**
- Early return when `root == p || root == q` is correct **because the nodes are guaranteed to exist**. If they may be missing, you need extra existence checks.
- Compare **node references**, not values (values may repeat).
- For a **BST** use the ordering instead: O(h) by walking down while both values are on the same side.
- Know the parent-pointer / path-storing alternatives.

**How to explain:** "I search both subtrees for p and q. The first node that finds one on each side is the lowest common ancestor. If only one side finds something, I pass that result up."
