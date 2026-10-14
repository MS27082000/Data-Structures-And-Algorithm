# Union of Two Sorted Arrays

**Problem:** Return the sorted union (distinct elements) of two sorted arrays.

**Brute force:** Put everything in a `TreeSet` → O((n+m) log(n+m)) time, O(n+m) space.
**Optimal:** Merge-style **two pointers**: always take the smaller front element, add it only if it differs from the last added → O(n+m) time.

**Intuition:** Both arrays are sorted, so the merged stream is sorted. Duplicates, within one array or across both, are adjacent in that stream, so comparing with the last added value removes all of them.

**Complexity:** Time O(n+m), Space O(1) extra (output aside).

**Edge cases:** One array empty, no overlap, all duplicates, identical arrays.

**Interview traps**
- Check duplicates against the **last added** element, not against the array neighbour. That covers cross-array duplicates too.
- Don't forget the tail loops for the leftover elements.
- A `HashSet` solution loses the sorted order, so you'd need to sort again.

**How to explain:** "Merge the two sorted arrays like merge sort, but only append a value if it's different from the last one appended."
