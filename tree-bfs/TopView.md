# Top View of a Binary Tree

**Problem:** The nodes visible when you look at the tree from above, listed from left to right.

**Approach:** BFS tracking each node's **horizontal distance (column)**: root 0, left child −1, right child +1. The **first node reached in each column** is the highest one, so store it only if the column is new (`putIfAbsent`). Output the columns in sorted order → O(n log n) with a `TreeMap` (or O(n) by tracking min/max column).

**Why BFS, not DFS:** BFS visits shallower nodes first, so the first node in a column really is the topmost. A plain DFS could meet a deeper node first.

**Intuition:** Two nodes in the same column overlap when viewed from above, and the one nearer the root hides the other.

**Complexity:** Time O(n log n), Space O(n).

**Edge cases:** Left- or right-skewed tree (all nodes visible), a single node, empty tree.

**Interview traps**
- **Use BFS** (level order). With DFS you must also store depth and compare.
- Keep the **first** node per column. (Bottom View keeps the **last**.)
- Output must be ordered by column, so use a sorted map.
- Nodes that are in the same column and same level: the first in left-to-right order wins.

**How to explain:** "I do a level-order traversal, giving each node a column. The first node I see in a column is the highest, so that's the one visible from the top."
