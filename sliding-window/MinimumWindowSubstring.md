# Minimum Window Substring (LC 76)

**Problem:** Given `s` and `t`, find the smallest substring of `s` containing **every character of `t`** (with multiplicity). Return `""` if none.

**Brute force:** Check every substring → O(n² · m).
**Optimal:** Sliding window (a **shortest** valid window) with a `need[]` count array and a `missing` counter.
1. Expand `right`. `need[c]--`; if `need[c]` was `> 0` before, a required character is covered → `missing--`.
2. While `missing == 0` (valid): record the window, then shrink: `need[s[left]]++`; if it becomes `> 0`, `missing++`. `left++`.

**Intuition:** `need[c] > 0` means we still require `c`; `≤ 0` means we have extras. The `missing` counter makes the validity check O(1) instead of comparing two maps.

**Complexity:** Time O(n + m), Space O(1) (128 or 256 slots).

**Edge cases:** `t` longer than `s` (`""`), duplicates in `t` (`"aa"`), the answer is the whole string, answer length 1, no answer.

**Interview traps**
- **Record the answer before shrinking** (this is a *shortest* window problem).
- Count only **genuinely needed** characters (`need[c]-- > 0`). Extras go negative.
- Use `missing` (total remaining) rather than comparing 52 counters each time.
- Handle multiplicity: `t = "aab"` needs two `a`s.
- Return the substring, not just the length.

**How to explain:** "I expand until the window covers all of t, then shrink from the left as far as it still does, recording the smallest. A single counter of missing characters tells me instantly when the window is valid."
