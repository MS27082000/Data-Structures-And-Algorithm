# Sort List (LC 148)

**Problem:** Sort a singly linked list in **O(n log n)** time (ideally O(1) extra space).

**Brute force:** Copy to an array, sort, rebuild → O(n log n) time, O(n) space.
**Optimal:** **Merge sort**, which suits linked lists:
1. Find the middle (slow/fast) and **cut** the list there.
2. Recursively sort both halves.
3. Merge the two sorted halves (Merge Two Sorted Lists).

**Why merge sort and not quick sort:** Merging needs no random access and no extra array, since nodes are just relinked. Quick sort and heap sort need random access.

**Intuition:** Linked lists split in the middle in O(n) and merge in O(1) extra space, which is exactly what merge sort needs.

**Complexity:** Time O(n log n), Space O(log n) recursion stack (top-down). A **bottom-up** merge sort gets O(1) space.

**Edge cases:** Empty or single node, already sorted, reverse sorted, duplicates, negative values.

**Interview traps**
- **Cut the list** (`slow.next = null`) before recursing. Otherwise the first half still points into the second and recursion never terminates.
- Start `fast = head.next` so that for two nodes `slow` is the first node (otherwise it infinite-loops on 2 elements).
- Mention that bottom-up merge sort gives true O(1) space.
- Don't sort by swapping values if the interviewer wants nodes relinked.

**How to explain:** "Split at the middle, sort each half recursively, and merge the sorted halves with the standard two-list merge. Linked lists make merging cheap, so merge sort is the natural choice."
