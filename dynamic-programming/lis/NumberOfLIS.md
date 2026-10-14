# Number of Longest Increasing Subsequences (LC 673)

**Problem:** Count how many LIS (maximum length) exist.

**Intuition:** Keep `len[i]` and `cnt[i]` (how many LIS of that length end at i). For each `j < i` with `a[j] < a[i]`: if `len[j]+1 > len[i]` -> replace (`cnt[i] = cnt[j]`); if equal -> add (`cnt[i] += cnt[j]`). Sum `cnt` over indices where `len == maxLen`.

**Brute force:** Enumerate all subsequences.
**Optimised:** O(n^2) time, O(n) space (O(n log n) with a Fenwick tree).

**Edge cases:** All equal -> every element is an LIS of length 1 (count n). Decreasing -> n.

**Interview traps**
- Sum counts only for the max length.
- Initialise both `len` and `cnt` to 1.

**How to explain:** "Length DP with a second array counting how many ways reach that length."
