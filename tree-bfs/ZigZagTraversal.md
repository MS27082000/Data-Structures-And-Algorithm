# Zig Zag / Spiral Traversal (LC 103)

**Problem:** Level order, but alternate direction: level 0 left→right, level 1 right→left, level 2 left→right, …

**Approach:** Run the normal level-order BFS, but write each level's values into an array at index `i` (left→right) or `size − 1 − i` (right→left), flipping a boolean every level. No reversal pass needed.

**Alternative:** Collect each level normally and `Collections.reverse` the odd levels. Same complexity.

**Intuition:** The **order of enqueuing never changes** (always left child then right child). Only where values are *placed* in the output changes.

**Complexity:** Time O(n), Space O(w).

**Edge cases:** Empty tree, a single node, levels of size 1 (direction doesn't matter), skewed trees.

**Interview traps**
- **Don't change the order in which you enqueue children** to achieve zigzag. That breaks the next level's order. Alternate only the output.
- Toggle the direction flag **after** each level.
- A two-stack solution also works (one per direction) but needs more code.

**How to explain:** "It's standard level-order BFS. I fill each level's result forwards or backwards depending on a flag that flips after every level."
