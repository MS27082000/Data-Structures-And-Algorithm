# Pascal's Triangle I, II, III

Each entry is the sum of the two above it. Entry at row `r`, column `c` (1-indexed) is **C(r-1, c-1)**.

## Variant I: element at row r, column c
- **Brute force:** Build the whole triangle → O(r²).
- **Optimal:** Compute `nCr` with a loop: `res = res * (n-i) / (i+1)` for `i < k`, using `k = min(k, n-k)` → O(k) time, O(1) space.
- **Trap:** Multiply first, then divide. The result is an exact integer at every step. Dividing early loses precision. Use `long` to avoid overflow.

## Variant II: print the n-th row
- **Brute force:** Compute `nCr` from scratch for each column → O(n²).
- **Optimal:** Each value from the previous: `C(n-1, c) = C(n-1, c-1) * (n-c) / c` → O(n) time.

## Variant III: first n rows (LC 118)
- Build each row with the formula above, or the classic "sum of two above" → O(n²) time and space (the output itself is O(n²)).

**Intuition:** Rows are binomial coefficients, so a neighbour in the same row is a ratio apart: `C(n,k+1) = C(n,k)·(n-k)/(k+1)`.

**Edge cases:** `n = 1` → `[1]`; first and last element of every row are 1; row/column indices are 1-based here.

**Interview traps**
- Off-by-one: row `r` has `r` elements and uses `C(r-1, ·)`.
- Don't compute full factorials (overflow). Use the incremental ratio.
- Row-by-row addition `row[j] = prev[j-1] + prev[j]` is fine for III, but II and I are expected in O(n) and O(k).

**How to explain:** "Pascal's triangle is binomial coefficients. For a single row or element I use the multiplicative formula so no factorials or full triangle are needed."
