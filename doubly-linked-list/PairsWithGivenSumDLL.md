# Find Pairs with Given Sum in a Doubly Linked List

**Problem:** A **sorted** DLL of distinct positive integers and a `target`. Return all pairs `(a, b)` with `a + b == target`.

**Brute force:** Check every pair → O(n²).
**Better:** `HashSet` of seen values → O(n) time, O(n) space.
**Optimal:** **Two pointers**: `left` at the head and `right` at the tail (found by walking to the end once). Then:
- `sum == target` → record, `left = left.next`, `right = right.prev`
- `sum < target` → `left = left.next`
- `sum > target` → `right = right.prev`

→ O(n) time, O(1) space.

**Intuition:** This is **Two Sum II on a linked list**. The `prev` pointer is what makes moving the right pointer backwards possible. A singly linked list couldn't do this in O(1) space.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** No pair, one element, empty list, multiple pairs, pointers meeting or crossing.

**Interview traps**
- **Stop when the pointers meet or cross:** `left != right && right.next != left`. Comparing values won't work. Compare **nodes**.
- Move **both** pointers after recording a pair.
- A node can't pair with itself (stops at `left == right`).
- The sorted order is what makes the shortcut valid. For unsorted input use a HashSet.

**How to explain:** "Same as two-sum on a sorted array: one pointer at each end, move the left forward if the sum is too small and the right backward if too large. The prev pointers let me move backwards."
