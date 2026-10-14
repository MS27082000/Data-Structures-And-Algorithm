# Pattern Printing (Patterns 1-22, Logic Building)

**Problem:** Print 22 classic star / number / alphabet patterns for a given n (the sheet's "Logic Building (Patterns)" group).

**The 4-step method (works for every pattern):**
1. Outer loop = **rows** (count them: n, 2n-1, or 2n).
2. For row i, how many **spaces** come first? (a formula in i, often `n - i - 1`)
3. For row i, how many **stars / numbers / letters**? (`i`, `n - i`, `2i + 1`, ...)
4. What is **printed** at each position - the column index j, the row number i, a running counter, or `'A' + something`?

**Pattern families**
- Squares and triangles (1-6, 13-16, 18): count depends on i.
- Pyramids and diamonds (7-10, 17): spaces `n-i-1` plus `2i+1` items.
- Mirrors (12, 19, 20): left part + middle spaces + mirrored right part.
- Border patterns (21, 22): decide by the distance of (i, j) from the four edges: `min(i, j, n-1-i, n-1-j)`.

**Brute force / optimised:** Nothing to optimise; time is O(n^2) because that many characters are printed. Space O(1).

**Edge cases:** n = 1, n = 0 (prints nothing), diamonds with the widest row printed once or twice (state which you chose).

**Interview traps**
- Off-by-one on the number of rows in the "2n - 1" patterns.
- Printing a trailing space or forgetting `println` at the end of each row.
- Using `char` arithmetic: `(char) ('A' + i)`.

**How to explain:** "I find the row count, then express spaces and symbols as functions of the row. Symmetric patterns are the same formula in a mirrored range."
