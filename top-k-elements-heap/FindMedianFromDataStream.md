# Find Median from Data Stream (LC 295)

**Problem:** Numbers arrive one at a time. Support `addNum(x)` and `findMedian()` (the middle value, or the mean of the two middle values).

**Brute force:** Keep a sorted list; each insert O(n) → O(n) per add. Re-sorting is O(n log n).
**Optimal: two heaps**
- `low`: a **max-heap** with the **smaller half**.
- `high`: a **min-heap** with the **larger half**.
- Invariants: every value in `low` ≤ every value in `high`, and `low.size() == high.size()` or `low.size() == high.size() + 1`.
- **add(x):** push into `low`, move `low`'s maximum to `high`, then if `high` got bigger than `low`, move one back → O(log n).
- **median:** odd count → `low.peek()`; even count → `(low.peek() + high.peek()) / 2.0` → **O(1)**.

**Intuition:** The median sits on the boundary between the two halves, and the two heap roots are exactly the elements next to that boundary.

**Complexity:** `addNum` O(log n), `findMedian` O(1), space O(n).

**Edge cases:** A single number, two numbers, duplicates, huge values (compute the mean in `long`/`double`), negatives.

**Interview traps**
- Which heap holds the **extra** element (here `low`, the max-heap) must be consistent.
- Do the "push to low, move to high, rebalance" dance. It guarantees ordering between halves even when the new value belongs to the other side.
- Average two `int`s as `((long) a + b) / 2.0` to avoid overflow.
- Follow-ups: sliding-window median (needs lazy deletion or `TreeMap`), and "99% of numbers in 0..100" (use a counting array).

**How to explain:** "I split the numbers into a lower half in a max-heap and an upper half in a min-heap, keeping them balanced. The median is then at the top of one heap or the mean of both tops, so adds cost O(log n) and the median costs O(1)."
