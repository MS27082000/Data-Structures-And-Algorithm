# K-th Largest Element in a Stream (LC 703)

**Problem:** Design a class that, after each `add(val)`, returns the **k-th largest** element among all elements added so far (initial elements included).

**Brute force:** Insert into a sorted list and index → O(n) per add. Re-sorting → O(n log n) per add.
**Optimal:** Keep a **min-heap of size k**. On `add`: push the value; if the size exceeds `k`, poll the smallest. The **root is the k-th largest** → **O(log k) per add**, O(k) space.

**Intuition:** Only the k largest elements can ever matter for the k-th largest. A min-heap of exactly those keeps the smallest of them (our answer) at the root, and anything smaller is irrelevant forever.

**Complexity:** `add` O(log k), space O(k).

**Edge cases:** Fewer than k elements initially (LeetCode guarantees enough by the time `add` is called), `k = 1` (tracks the maximum), duplicates, negatives.

**Interview traps**
- It is a **min**-heap (not max) for the k-th **largest**.
- Don't store the entire stream. That defeats the point of the design.
- If `add` can be called with fewer than k elements, decide what to return (null/exception).
- Same structure answers "k-th largest in an array" (process the array as a stream).

**How to explain:** "I maintain a min-heap that holds only the k largest elements. Its root is the k-th largest. Each new value is pushed and, if the heap is too big, the smallest is removed, which costs O(log k)."
