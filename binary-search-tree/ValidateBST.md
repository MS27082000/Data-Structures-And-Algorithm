# Check if a Tree is a BST (Validate BST, LC 98)

**Problem:** Is a given binary tree a valid BST? (Strictly: all left-subtree keys < node < all right-subtree keys.)

**Wrong approach (classic trap):** Only check `node.left.val < node.val < node.right.val`. This misses violations deeper down, e.g. `5 → (1, 4 → (3, 6))` has `3 < 5` in the **right** subtree.

**Approach 1 (bounds, recommended):** Pass an **open interval `(low, high)`** down. A node must satisfy `low < node.val < high`. Going **left** sets `high = node.val`; going **right** sets `low = node.val`. Start with `(−∞, +∞)` → O(n).
**Approach 2 (inorder):** A BST's inorder is **strictly increasing**. Track the previously visited value; if `current <= prev` → invalid → O(n).

**Intuition:** Every node inherits constraints from **all of its ancestors**, which is exactly what the shrinking interval tracks.

**Complexity:** Time O(n), Space O(h).

**Edge cases:** Empty tree (valid), a single node, **duplicates** (invalid with strict inequalities), keys equal to `Integer.MIN_VALUE` or `MAX_VALUE`.

**Interview traps**
- **Use `long` bounds** (or `null`/`Integer` objects), not `Integer.MIN_VALUE` / `MAX_VALUE`, or valid trees with those keys fail.
- Use **strict** comparisons (`<=` fails the check).
- Don't validate with local parent-child comparisons only.
- A single "previous" variable must be shared across recursive calls (a field, not a parameter).

**How to explain:** "Each node must fall strictly between the bounds set by its ancestors: going left lowers the upper bound to the parent's value, going right raises the lower bound. If every node respects its bounds, the tree is a BST."
