# Minimise Maximum Distance to Gas Station (LC 774)

**Problem:** Gas stations on a line (sorted positions). Add `k` new stations anywhere (not necessarily at integers). Minimise the largest gap between adjacent stations.

**Brute force / better:**
- Greedy with a max-heap: repeatedly add a station into the currently largest gap (track how many pieces each gap is split into) → O(k log n).
- Fine for small `k`, too slow when `k` is large.

**Optimal:** **Binary search on the answer** (a real number) → O(n log(range / ε)).

**Feasibility check:** For a target distance `d`, a gap `g` needs `ceil(g / d) - 1` new stations. Sum over gaps. If the total `<= k` → feasible, so try a smaller `d`.

**Intuition:** A smaller maximum gap needs more stations, so it is monotonic. We binary search a **floating-point** answer until `high - low < 1e-6`.

**Complexity:** Time O(n log(range / 1e-6)), Space O(1).

**Edge cases:** `k = 0` (answer is the current max gap), a single gap, large `k`, exact multiples (`gap == d * pieces`).

**Interview traps**
- It's a **real-valued** binary search. Loop on `high - low > eps`, not `low < high` on ints.
- When `gap` divides evenly by `d`, subtract one piece (`gap == d * pieces`), or you over-count.
- Precision: `1e-6` is enough for the usual `1e-5` tolerance.
- Mention the heap approach first, then explain why binary search wins when `k` is large.

**How to explain:** "I binary search the maximum allowed gap. For each candidate, I count how many stations are needed to split every gap to at most that size and compare with k."
