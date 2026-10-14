# Largest Rectangle in a Histogram (LC 84)

**Problem:** Bars of width 1 and given heights. Find the area of the largest rectangle that fits in the histogram.

**Brute force:** For every pair of bars compute the min height between them → O(n²).
**Better:** For each bar, expand left and right while bars are at least as tall → O(n²) worst case.
**Optimal:** **Monotonic increasing stack of indices** → O(n).

**Key idea:** The best rectangle using bar `i` as its **height** extends left to the previous **smaller** bar and right to the next **smaller** bar. Width = `nextSmaller − previousSmaller − 1`.

**Stack algorithm:** Scan `i = 0..n` (use height `0` at `i = n` as a sentinel to flush the stack). While the top bar is taller than the current one, pop it: `height = h[popped]`, `left = new stack top (or -1)`, `width = i − left − 1`, `area = height × width`.

**Intuition:** A bar stays on the stack while its right side is still "open" (no smaller bar yet). The moment a smaller bar arrives, the popped bar's rectangle is finalised.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** Single bar, all equal, increasing (the last rectangle is found by the sentinel), decreasing, zeros, empty input.

**Interview traps**
- The **sentinel 0** at the end is what pops the remaining bars.
- Width uses the **new** stack top after popping (`i − left − 1`), not the popped index.
- Equal heights are fine: either pop or keep, the area is still found later.
- This is the base for **Maximal Rectangle** (apply it to each row's histogram).

**How to explain:** "For every bar I want the widest span where it is the shortest bar. A stack of increasing bars finds, for each popped bar, the previous and next smaller bars, which are the boundaries of its best rectangle."
