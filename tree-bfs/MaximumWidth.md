# Maximum Width of a Binary Tree (LC 662)

**Problem:** The width of a level is the distance between its **leftmost and rightmost non-null nodes**, **counting the missing (null) nodes between them** as if the tree were complete. Return the maximum width over all levels.

**Brute force:** Fill the tree into a complete-tree array with nulls. Memory explodes for skewed trees (2ⁿ).
**Optimal:** BFS giving each node a **heap index**: left child = `2·i`, right child = `2·i + 1`. The width of a level = `lastIndex − firstIndex + 1` → O(n), O(w).

**Overflow guard:** In a deep skewed tree the indices reach 2ᵈ. **Normalise each level** by subtracting that level's first index before computing children (`index − first`), and use `long`.

**Intuition:** In a complete-tree layout, the positions of nodes on a level are consecutive integers, so index differences count the nulls between nodes for free.

**Complexity:** Time O(n), Space O(w).

**Edge cases:** Empty tree (0), a skewed tree (width 1 at every level), nulls in the middle of a level (`[1,3,2,5,null,null,9,6,null,7]` → 7).

**Interview traps**
- **Overflow** is the real trap. Normalise per level and use `long`.
- Use the **first node on the level** as the base, not the root index.
- Counts nulls **between** the extreme nodes only, not at the ends.
- Don't confuse with "maximum number of nodes in a level".

**How to explain:** "I number nodes like a heap, so a level's width is last index minus first index plus one. I subtract the level's first index before computing children, so the numbers never overflow."
