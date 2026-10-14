# Sliding Window: Pattern and Template (Theory)

**Idea:** Maintain a **window** `[left, right]` over an array or string. Instead of recomputing from scratch for each subarray (O(n²)), you **update incrementally**: add the element entering at `right`, remove the one leaving at `left`. Total O(n), since each pointer only moves forward.

## When to use
Keywords: **contiguous** subarray / substring, longest / shortest / count / max-sum, "at most K", "exactly K", window of size K.
**Does not work directly** when the condition isn't monotonic with window size, e.g. **negative numbers** with sum conditions (use prefix sums + hashmap instead).

## The four shapes

| # | Shape | Loop skeleton | Example |
|---|---|---|---|
| 1 | **Fixed size k** | `sum += a[r] - a[r-k]` | Max points from cards |
| 2 | **Longest valid window** | expand `r`; `while (invalid) left++`; `best = max(best, r-l+1)` | Longest without repeating, Max Consecutive Ones III, Fruit, K distinct |
| 3 | **Shortest valid window** | expand `r`; `while (valid) { record; left++ }` | Minimum Window Substring |
| 4 | **Count subarrays** | `exactly(K) = atMost(K) − atMost(K−1)`; `count += r-l+1` | Binary Subarrays, Nice Subarrays, K Different Integers |

## Templates
```java
// Longest valid window
int left = 0;
for (int right = 0; right < n; right++) {
    add(a[right]);
    while (!valid()) { remove(a[left]); left++; }
    best = Math.max(best, right - left + 1);
}

// Shortest valid window
for (int right = 0; right < n; right++) {
    add(a[right]);
    while (valid()) { best = Math.min(best, right - left + 1); remove(a[left]); left++; }
}
```

## Why "atMost" counting works
Counting windows with **exactly** K is awkward, but **at most** K is monotonic (shrinking a valid window keeps it valid). For each `right`, all `right - left + 1` windows ending there are valid, so add that. Then `exactly(K) = atMost(K) − atMost(K−1)`.

## Complexity
Time O(n) (each element enters and leaves the window once). Space O(1) to O(k) for the counters.

## Common traps
- **Record the answer at the right moment:** *longest* → after restoring validity; *shortest* → **before** shrinking.
- Use a frequency array/map and **remove keys at 0** when you need `size()` as the distinct count.
- Negative numbers break "shrink while sum > target".
- Off-by-one on window length: `right - left + 1`.
- Distinguish **window** (contiguous) from **subsequence** (not contiguous).

**How to explain:** "I keep a window and move the right edge forward one element at a time. When the window breaks the rule I move the left edge forward until it's valid again. Each pointer only moves forward, so it's linear."
