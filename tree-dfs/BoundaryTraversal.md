# Boundary Traversal of a Binary Tree

**Problem:** Print the **boundary** in **anti-clockwise** order starting from the root: the root, then the **left boundary** (top to bottom), then **all leaves** (left to right), then the **right boundary** (bottom to top).

**Approach:** Three separate walks, with care so that **no node appears twice**:
1. **Root** (skip if it is a leaf; it is added with the leaves).
2. **Left boundary:** start from `root.left`; add each node that is **not a leaf**; move to the left child if it exists, otherwise the right child.
3. **Leaves:** a DFS that adds leaves in left-to-right order (covers the leaves of both subtrees).
4. **Right boundary:** same as the left boundary mirrored, but collect and **reverse** it (bottom to top), again excluding leaves.

**Intuition:** The boundary is made of three pieces: the left spine, the bottom (leaves), and the right spine. Excluding leaves from the spines keeps them from being listed twice.

**Complexity:** Time O(n), Space O(h) extra (O(n) for the right-boundary list in the worst case).

**Edge cases:** A single node (only the root), a skewed tree (all nodes are on the boundary), no left subtree or no right subtree, a left boundary that turns into the right child.

**Interview traps**
- **Exclude leaves from both boundaries**, and don't add the root twice when it is a leaf.
- The boundary follows the **left child if present, else the right child** (the left boundary can zigzag down the right side when the left child is missing).
- The right boundary is added **in reverse** order.
- Internal nodes that are not on either spine are not part of the answer, even though they aren't leaves.

**How to explain:** "I output the root, then walk down the left edge skipping leaves, then collect every leaf from left to right, then walk down the right edge skipping leaves and add it in reverse."
