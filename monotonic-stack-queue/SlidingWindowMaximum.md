# Sliding Window Maximum (LC 239)

**Problem:** For every window of size `k` in an array, output the maximum.

**Brute force:** Scan each window → O(n·k).
**Better:** A max-heap with lazy deletion → O(n log n).
**Optimal:** A **monotonic decreasing deque of indices** → O(n).

**Invariant:** The deque holds indices whose values are **strictly decreasing** from front to back. The **front is the maximum** of the current window.
For each `i`:
1. If the front index is `<= i − k`, it left the window, so `pollFirst`.
2. While the back value is `<= nums[i]`, `pollLast` (they can never be a maximum while `nums[i]` is in the window, since `nums[i]` is larger **and** will stay longer).
3. `offerLast(i)`.
4. When `i >= k − 1`, record `nums[front]`.

**Intuition:** A smaller element that appears earlier than a larger one is dominated. It will leave the window first and is never bigger, so it can be dropped immediately.

**Complexity:** Time O(n) (each index is added and removed once), Space O(k).

**Edge cases:** `k = 1` (the array itself), `k = n` (one value), equal elements, decreasing array (every index stays in the deque), negatives.

**Interview traps**
- **Store indices, not values**, so you can tell when the front expires.
- Remove expired indices from the **front**, dominated ones from the **back**.
- First answer is at `i = k − 1`; the result has `n − k + 1` elements.
- Know the heap solution as a fallback.

**How to explain:** "I keep a deque of candidate indices with decreasing values. The front is always the current maximum. When the window moves I drop the front if it expired, and drop smaller values from the back before adding the new index."
