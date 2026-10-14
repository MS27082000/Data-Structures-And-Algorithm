# Number of Greater Elements to the Right

**Problem:** Given an array and a list of query indices, for each query index `i` return the **count of elements to the right of `i` that are strictly greater than `arr[i]`**.

> This is a **counting** problem, not "find the next greater". A monotonic stack gives only the *first* greater element, not how many there are.

**Brute force:** For each query scan to the right → O(n) per query, O(q·n) total. Good when `q` is small.
**Optimal (all indices, O(n log n)):** Process the array **right to left** with a **Fenwick tree (BIT)** over **coordinate-compressed** values:
1. Compress the values to ranks `1..m`.
2. For index `i`, `notGreater = BIT.query(rank(arr[i]))` = how many already-inserted (right-side) values are `<= arr[i]`.
3. `count[i] = (n − 1 − i) − notGreater`.
4. Insert `arr[i]` into the BIT.
Then answer each query by lookup.

**Alternatives:** Merge sort counting (like Count Inversions), or an order-statistic tree.

**Intuition:** Everything to the right is either `<= arr[i]` or `> arr[i]`. The BIT counts the first group quickly, and the second group is the remainder.

**Complexity:** Time O(n log n) preprocessing + O(1) per query. Space O(n).

**Edge cases:** Duplicates (equal is **not** greater: counts 0 for `[5,5,5]`), last index (0), strictly decreasing (0 everywhere), strictly increasing (`n − 1 − i`).

**Interview traps**
- Don't reach for a monotonic stack. It answers a different question.
- Ask how many queries there are. For one or two queries brute force is the right answer.
- Compression is needed when values are large; ranks keep the BIT small.
- Strict vs non-strict comparison changes the counts with duplicates.

**How to explain:** "For a few queries I just scan. To answer for every index, I sweep from the right keeping a Fenwick tree of the values seen so far, and the count of greater elements is everything inserted minus the count of values not greater."
