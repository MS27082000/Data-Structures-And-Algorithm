# Construct a BST from a Preorder Traversal (LC 1008)

**Problem:** Given the preorder traversal of a BST (distinct keys), rebuild the tree.

**Approach 1 (insert each value):** Insert the values one by one → O(n·h), O(n²) worst case.
**Approach 2 (sort for inorder + the generic construct):** Sort the preorder to get inorder, then use Preorder + Inorder construction → O(n log n).
**Optimal (bounds, O(n)):** Walk the preorder array once with a shared index and an **upper bound**:
- If the next value is **greater than the bound**, it belongs to an ancestor's right side → return `null`.
- Otherwise create the node, then build the **left** subtree with `bound = node.val`, then the **right** subtree with the **inherited bound**.

**Intuition:** In preorder, after a node come all its left-subtree keys (all smaller), then the right-subtree keys. The bound tells each recursive call where its subtree ends, so no searching or splitting is needed.

**Complexity:** Time O(n), Space O(h).

**Edge cases:** A single value, strictly increasing input (right chain), strictly decreasing (left chain).

**Interview traps**
- The index must be **shared** (a field or array), not passed by value.
- Pass the **inherited** bound to the right call, not `Integer.MAX_VALUE`.
- Unlike an arbitrary binary tree, **preorder alone is enough** for a BST (inorder is just the sorted keys).
- Mention the O(n log n) sort-and-construct alternative.

**How to explain:** "I read the preorder once. A value fits in the current subtree only if it's below the upper bound. I build the left subtree with the node's value as the new bound and then the right subtree with the old bound."
