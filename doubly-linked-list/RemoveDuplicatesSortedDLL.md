# Remove Duplicates from a Sorted Doubly Linked List

**Problem:** A **sorted** DLL may contain duplicates. Keep exactly one node of each value.

**Brute force:** Use a `HashSet` of seen values → O(n) time, O(n) space. It doesn't use the sorted property.
**Optimal:** Because the list is sorted, equal values are **adjacent**. Compare each node with its next. While equal, unlink the next node → O(n) time, O(1) space.

**Steps:** `cur = head`. If `cur.val == cur.next.val`: `dup = cur.next; cur.next = dup.next; if dup.next != null: dup.next.prev = cur;` (don't advance). Otherwise `cur = cur.next`.

**Intuition:** Duplicates of a value form one contiguous block. Keep the first node of the block and cut out the rest.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** All elements equal (`5,5,5,5` → `5`), no duplicates, duplicates at the end, empty list.

**Interview traps**
- **Don't advance `cur`** after removing a duplicate, since the new next may be another duplicate.
- Update **both** pointers (`cur.next` and `dup.next.prev`).
- The head never changes, because the first node of any block is kept.
- If the list were **unsorted** you'd need a HashSet (or sort first).

**How to explain:** "Since the list is sorted, duplicates sit next to each other. I stay on a node and keep removing its next while it has the same value, fixing both links each time."
