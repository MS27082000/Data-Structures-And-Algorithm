# Search in a BST (LC 700)

**Problem:** Return the node whose value equals `val` (and so its whole subtree), or `null`.

**Brute force:** Traverse the entire tree like a normal binary tree → O(n).
**Optimal:** Use the BST order. At each node: equal → found; `val < node.val` → go **left**; else go **right**. Half of the tree is discarded each step → **O(h)**.

**Iterative:** `while (cur != null && cur.val != val) cur = val < cur.val ? cur.left : cur.right;` → O(1) space.
**Recursive:** same logic with O(h) stack.

**Intuition:** It's binary search where the "midpoint" is the current node.

**Complexity:** Time O(h) (O(log n) balanced, O(n) skewed), Space O(1) iterative / O(h) recursive.

**Edge cases:** Empty tree, value at the root, value absent, skewed tree.

**Interview traps**
- Don't search both subtrees. That defeats the BST.
- Return the **node**, not a boolean, if asked for the subtree.
- Say that the worst case is O(n) for an unbalanced tree.

**How to explain:** "I compare with the current node and go left or right accordingly, ignoring the other half. That takes time proportional to the height."
