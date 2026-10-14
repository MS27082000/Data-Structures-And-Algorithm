# Word Search (LC 79)

**Problem:** In a grid of letters, does the word exist by moving to **adjacent** cells (up/down/left/right), using each cell **at most once** in a path?

**Brute force:** Enumerate all paths → exponential without pruning.
**Optimal:** **DFS + backtracking.** Start from every cell that matches `word[0]`. At each step match `word[index]`, mark the cell visited, try 4 directions, then **unmark**.

**Intuition:** Visited marking prevents reusing a cell in the **current** path, and unmarking lets other paths use it later.

**Marking trick:** Temporarily overwrite the cell with `'#'` and restore it → no extra `visited` array (O(1) extra besides the stack).

**Complexity:** Time O(m · n · 3^L) (after the first move only 3 directions are new), Space O(L) stack (L = word length).

**Edge cases:** Word longer than the number of cells, a single-cell grid, repeated letters (`"aaa"` in `"aa"`), word reusing a cell (must be false).

**Interview traps**
- **Restore the cell** after exploring (the backtrack step). Forgetting it breaks later searches.
- Check bounds **before** reading the cell.
- Pruning: if the grid doesn't have enough of each letter, return false early. If the last letter of the word is rarer than the first, search the reversed word.
- The base case is `index == word.length()`.

**How to explain:** "I run DFS from every cell that matches the first letter, marking cells as used on the way down and restoring them on the way back. Success if I match the whole word."
