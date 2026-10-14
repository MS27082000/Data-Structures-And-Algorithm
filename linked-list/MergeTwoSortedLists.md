# Merge Two Sorted Lists (LC 21)

**Problem:** Merge two sorted linked lists into one sorted list by splicing together the existing nodes.

**Brute force:** Dump both into an array, sort, rebuild → O((m+n) log(m+n)), extra space.
**Optimal (iterative):** A **dummy head** and a `tail` pointer. Repeatedly attach the smaller front node and advance. When one list ends, attach the rest of the other → O(m + n) time, O(1) space.
**Recursive:** Pick the smaller head and set its `next` to the merge of the rest → O(m + n) time, O(m + n) stack.

**Intuition:** Same as the merge step of merge sort. Both lists are already sorted, so the smallest remaining element is always at one of the two fronts.

**Complexity:** Time O(m + n), Space O(1) iterative.

**Edge cases:** One or both lists empty, all of one list smaller than the other, duplicates, different lengths.

**Interview traps**
- The dummy node avoids a special case for the first node.
- **Attach the leftover list directly** (`tail.next = l1 != null ? l1 : l2`). No need to loop through it.
- Use `<=` to keep the merge **stable**.
- This is the building block for **Sort List**, **Merge k Sorted Lists**, and **Flatten Linked List**.

**How to explain:** "Compare the two front nodes, append the smaller to the result, and advance. When one list runs out I attach the remainder of the other. It reuses the existing nodes, so no extra space."
