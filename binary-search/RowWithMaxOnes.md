# Find the Row with Maximum 1's

**Problem:** A binary matrix where each row is sorted (all 0s then all 1s). Return the index of the row with the most 1s (smallest index on ties).

**Brute force:** Count the 1s in every row → O(m·n).
**Optimal:** In each row, binary search the **first 1**. Ones in the row = `n - firstOneIndex`. Track the best row → O(m log n).

**Alternative (O(m + n)):** Start at the top-right corner. Move left while you see a 1 (remember that row), otherwise move down. That is the same staircase idea as Search 2D Matrix II.

**Intuition:** A row `0 0 0 1 1` is a "false … true" pattern, so the first true can be found with lower bound.

**Complexity:** Time O(m log n), Space O(1).

**Edge cases:** No 1s at all (return -1), all 1s, ties (keep the smaller index), a single row or column.

**Interview traps**
- Use a strict `>` when updating the best, so ties keep the smallest row.
- No ones in a row: `firstOne = n`, which gives 0 ones. Good, no special case.
- Know the O(m + n) staircase alternative.

**How to explain:** "Each row is sorted, so I binary search where its 1s start. The count is the row length minus that index, and I keep the row with the largest count."
