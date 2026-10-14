# Largest BST in a Binary Tree (LC 333)

**Problem:** Given a binary tree (not necessarily a BST), find the **size (number of nodes)** of the largest subtree that is itself a valid BST.

**Brute force:** For every node run "validate BST" and count nodes → **O(n²)**.
**Optimal (one postorder pass, O(n)):** Each call returns a small record for its subtree: `{isBST, size, min, max}`. A node forms a BST if
- both children are BSTs, **and**
- `left.max < node.val < right.min`.
Then `size = left.size + right.size + 1`, `min = min(left.min, node)`, `max = max(right.max, node)`, and update the global best. Otherwise the node is **not** a BST and reports the larger child size (so the best is still tracked). An **empty** subtree is a BST of size 0 with `min = +∞`, `max = −∞`.

**Intuition:** Checking children first means each subtree's validity and range are computed **once**, so a parent can decide in O(1) instead of re-scanning.

**Complexity:** Time O(n), Space O(h).

**Edge cases:** A single node (1), the whole tree being a BST, no multi-node BST (answer 1), an empty tree (0), a bad node deep inside an otherwise good tree.

**Interview traps**
- The largest BST is a **complete subtree** (a node with all its descendants), not an arbitrary subset of nodes.
- Use `+∞/−∞` sentinels (or `long`) for empty subtrees so the comparisons work.
- Update the global best only for **valid** subtrees.
- Once a node isn't a BST, none of its ancestors can be, but other branches still might be.

**How to explain:** "I go bottom-up. Each subtree reports whether it's a BST, its size, and its min and max. A parent is a BST if both children are and the parent's value fits between the left max and the right min; I track the biggest valid size."
