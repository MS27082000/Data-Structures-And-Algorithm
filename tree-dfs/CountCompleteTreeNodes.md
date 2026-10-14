# Count Total Nodes in a Complete Binary Tree (LC 222)

**Problem:** Count the nodes of a **complete** binary tree (every level full except possibly the last, which is filled left to right) in **less than O(n)**.

**Brute force:** Any traversal → O(n).
**Optimal:** Compute the **leftmost height** `lh` (follow `left` pointers) and the **rightmost height** `rh` (follow `right` pointers).
- If `lh == rh` the subtree is a **perfect** tree, so it has exactly `2^lh − 1` nodes (just use the formula).
- Otherwise `1 + count(left) + count(right)`.

**Why it's fast:** In a complete tree at least one of the two children is **perfect**, so only one branch keeps recursing. Each level costs O(log n) for the height computation → **O(log² n)** total.

**Complexity:** Time O(log² n), Space O(log n) stack.

**Edge cases:** Empty tree (0), a single node, a perfect tree (formula only), the last level partly filled.

**Interview traps**
- This only works for **complete** trees. For a general tree you need O(n).
- Use `1 << h` for `2^h`, and mind `h` up to ~30 (fits in `int` for LeetCode's limits).
- Heights are counted in **nodes** (empty = 0).
- A binary-search-on-the-last-level approach also gives O(log² n). Mention it if asked.

**How to explain:** "If the left-most and right-most paths have the same height the subtree is perfect and I can use 2^h − 1. Otherwise I count the root plus both children recursively. In a complete tree only one side recurses, so it takes O(log² n)."
