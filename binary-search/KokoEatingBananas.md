# Koko Eating Bananas (LC 875)

**Problem:** Piles of bananas, `h` hours. Each hour Koko eats up to `k` bananas from **one** pile. Find the minimum integer `k` to finish within `h` hours.

**Brute force:** Try `k = 1, 2, …` → O(n · max).
**Optimal:** **Binary search on `k`** in `[1, max(piles)]`. Hours needed = `Σ ceil(pile / k)`, which decreases as `k` grows → O(n log max).

**Steps:** If `hours(mid) <= h` → feasible, try smaller (`high = mid`). Else `low = mid + 1`.

**Intuition:** Faster speed can never take more time, so feasibility is monotonic. We want the first feasible speed.

**Complexity:** Time O(n log max), Space O(1).

**Edge cases:** `h == n` (answer = `max`), huge `h` (answer 1), a single pile, large pile values (use `long` for hours).

**Interview traps**
- Ceil division: `(p + k - 1) / k`.
- Upper bound `max(piles)`. Going faster than the largest pile doesn't help.
- Hours can overflow `int` with large inputs. Use `long`.
- Recognise this as a "binary search on answer" problem (monotonic feasibility).

**How to explain:** "If Koko can finish at speed k she can finish at any faster speed. So I binary search the smallest k whose total hours is at most h."
