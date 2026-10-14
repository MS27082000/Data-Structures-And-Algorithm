# Vertical Order Traversal (LC 987)

**Problem:** Draw vertical lines through the tree. Group nodes by **column** (root = 0, left child = col − 1, right child = col + 1), and list the columns from left to right. Within a column, order by **row (top to bottom)**, and for nodes in the **same row and column, by value**.

**Approach:** Traverse (BFS or DFS) recording `(column, row, value)` for every node. Store in a `TreeMap<column, List<{row, value}>>` (sorted by column). Sort each column's list by `(row, value)` and output the values → O(n log n).

**Intuition:** Each node's position is a coordinate pair (col, row). The output is just "sort by column, then row, then value".

**Complexity:** Time O(n log n), Space O(n).

**Edge cases:** Two nodes at the same `(row, col)` (sort by value), a skewed tree (each node in its own column), empty tree.

**Interview traps**
- **Tie-break by value** for same row and column. Plain BFS order isn't enough.
- Track **row** as well as column. Using only the column loses the top-to-bottom order across subtrees.
- Use `TreeMap` (sorted keys), or track `minCol`/`maxCol` and use a list for O(n) columns.
- Easy to confuse with **Top/Bottom View** (one node per column) and **Vertical Order (LC 314)** (no value tie-break).

**How to explain:** "I give every node a column and a row, group by column in sorted order, and within each column sort by row and then by value."
