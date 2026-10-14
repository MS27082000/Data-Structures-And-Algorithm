# Flattening a Linked List

**Problem:** A multilevel list: each node has a `next` pointer (to the next column's head) and a `bottom` pointer (a **sorted** list below it). Flatten it into one sorted list, linked through `bottom`.

**Brute force:** Collect all values, sort, rebuild → O(N log N) time, O(N) space (N = total nodes).
**Optimal:** **Merge the columns**, using the Merge Two Sorted Lists logic on `bottom` pointers. Recursively flatten the list starting at `head.next`, then merge `head`'s column with the flattened rest.

**Intuition:** Each column is already a sorted list, so flattening is the same as merging `k` sorted lists, done pairwise from the right.

**Complexity:** Time O(N · k) in the worst case (the growing merged list is re-scanned with each merge, k = number of columns). Space O(k) recursion stack.
**Better for large k:** a min-heap over the column heads → O(N log k).

**Edge cases:** Empty list, a single column, columns of different lengths, duplicate values.

**Interview traps**
- The result is linked with **`bottom`**, and `next` should be `null` (set `head.next = null`).
- The `merge` function must use `bottom` instead of `next`.
- Mention the heap alternative.
- Related: Merge K Sorted Lists (LC 23).

**How to explain:** "Each vertical list is sorted, so I flatten from the right: merge the last two columns, then merge the previous column into that result, and so on, using a standard two-sorted-lists merge on the bottom pointers."
