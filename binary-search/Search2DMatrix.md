# Search a 2D Matrix (LC 74)

**Problem:** An `m x n` matrix where each row is sorted and the first element of each row is greater than the last element of the previous row. Does `target` exist?

**Brute force:** Scan everything → O(m·n).
**Better:** Binary search the correct row, then binary search inside it → O(log m + log n).
**Optimal (clean):** Treat the matrix as one **flattened sorted array** of length `m·n` → O(log(m·n)).

**Index mapping:** For a flat index `k`: `row = k / n`, `col = k % n`.

**Intuition:** The two conditions together mean that reading row by row gives one globally sorted sequence, so plain binary search applies with the index mapping.

**Complexity:** Time O(log(m·n)), Space O(1).

**Edge cases:** Empty matrix or empty row, single cell, target at the corners, target absent.

**Interview traps**
- Divide and mod by the **number of columns** `n`, not rows.
- Don't confuse with Search 2D Matrix II (rows and columns sorted *separately*), which needs the staircase search.
- Guard against an empty matrix before reading `m[0].length`.

**How to explain:** "The rows chain together into one sorted array, so I binary search 0 to m·n-1 and convert each index into a row and column."
