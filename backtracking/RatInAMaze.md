# Rat in a Maze

**Problem:** An `n × n` maze where `1` = open and `0` = blocked. A rat starts at `(0,0)` and wants to reach `(n-1,n-1)` moving **D, L, R, U**. Return all paths (as direction strings) in **lexicographic order**. A cell can't be visited twice on one path.

**Brute force:** Try all move sequences → exponential without pruning.
**Optimal:** **DFS + backtracking.** At each cell try the four directions in the order `D, L, R, U` (already alphabetical), moving to a cell only if it's inside the grid, open, and not visited in the current path. Mark visited on entry and **unmark on exit**.

**Intuition:** Trying directions in alphabetical order means the paths are found in lexicographic order with no sorting needed.

**Complexity:** Time O(4^(n²)) worst case, Space O(n²) for the visited array and stack.

**Edge cases:** Start or end blocked (no path), `1×1` open maze (one empty path), dead ends, mazes with many loops.

**Interview traps**
- Direction order **D, L, R, U** gives lexicographic order. Using U, D, L, R gives the wrong order.
- **Unmark** the cell when backtracking. Otherwise only one path will ever be found.
- Check the start and end cells first.
- Without the `visited` array the search loops forever.

**How to explain:** "I do a DFS from the start, trying down, left, right, up in that order, marking cells visited on the current path and unmarking on return. Every time I reach the bottom-right I record the path string."
