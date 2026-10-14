# Top K Frequent Elements (LC 347)

**Problem:** Return the `k` most frequent values (in any order). The answer is guaranteed to be unique.

**Brute force:** Count, then sort all distinct values by frequency → O(n log n).
**Heap:** Count with a `HashMap`; keep a **min-heap of size k** ordered by frequency. Push each entry and poll when the size exceeds `k` → **O(n log k)** time, O(n) space.
**Bucket sort (best):** A frequency is at most `n`, so use an array of buckets where `bucket[f]` holds the values that occur `f` times. Scan buckets from `n` down and collect `k` values → **O(n)**.
**Quickselect** on the frequency array is another O(n) average option.

**Intuition:** It's the Top-K pattern applied to frequencies. The **min**-heap discards the least frequent of the current k + 1 candidates.

**Complexity:** Heap O(n log k) / O(n). Bucket sort O(n) / O(n).

**Edge cases:** `k` equal to the number of distinct values, a single element, all equal, ties (the guarantee removes them on LeetCode).

**Interview traps**
- **Min**-heap for the **top** k (not max).
- Order the heap by **frequency**, not by value.
- Bucket array size is `n + 1` (a value can appear `n` times).
- Mention that bucket sort beats the heap when asked "can you do better than O(n log n)?"

**How to explain:** "I count frequencies, then keep a min-heap of size k keyed by frequency, evicting the least frequent. What remains are the k most frequent values. Bucketing by frequency does it in linear time."
