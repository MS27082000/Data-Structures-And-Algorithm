# Maximal Rectangle (LC 85)

**Problem:** A binary matrix of `'0'` and `'1'`. Find the largest rectangle containing only `'1'`s and return its area.

**Brute force:** Try every rectangle → O(m²·n²) or worse.
**DP:** Per cell store height/left/right boundaries → O(m·n), O(n).
**Optimal (reduce to a known problem):** Treat each row as the **base of a histogram**. `heights[j]` = number of consecutive `1`s ending at this row in column `j` (reset to 0 on a `'0'`). Run [Largest Rectangle in Histogram](LargestRectangleHistogram.md) on that array for every row and keep the maximum → O(rows × cols) time, O(cols) space.

**Intuition:** Any all-ones rectangle has a bottom edge in some row. For that row, the rectangle is a rectangle under the histogram of ones stacked above it.

**Complexity:** Time O(m·n), Space O(n).

**Edge cases:** Empty matrix, all zeros (0), all ones (`m·n`), a single row or column, a `'0'` that resets a column.

**Interview traps**
- Input values are **characters** (`'1'`), not ints. Compare to `'1'`.
- **Reset the height to 0** on a `'0'` (`heights[j] = 0`), not decrement.
- Reuse one `heights` array across rows for O(cols) space.
- Recognising the reduction to Largest Rectangle in Histogram is the whole question.

**How to explain:** "I build a histogram for each row counting consecutive ones above it, and the largest all-ones rectangle ending at that row is the largest rectangle in that histogram. I take the best over all rows."
