# Merge K Sorted Lists (LC 23)

**Problem:** Merge `k` sorted linked lists into one sorted list.

**Brute force:** Collect all values, sort, rebuild → O(N log N), where `N` is the total number of nodes.
**Sequential merge:** Merge lists one after another → O(N·k).
**Min-heap (k-way merge):** Put the **head of each list** in a min-heap. Poll the smallest node, append it to the result, and push **that node's `next`** (if any) → **O(N log k)** time, O(k) space.
**Divide and conquer:** Merge the lists **in pairs** like merge sort (k → k/2 → … → 1) using the two-list merge → **O(N log k)** time, O(log k) stack, no heap.

**Intuition:** At any moment the next output node must be the smallest of the k current heads. The heap finds it in O(log k).

**Complexity:** Time O(N log k), Space O(k) (heap) or O(log k) (divide and conquer).

**Edge cases:** Empty array of lists, some lists `null`/empty, a single list, duplicates, negatives.

**Interview traps**
- **Skip `null` heads** before pushing (a `null` node in the heap throws).
- Push `smallest.next` **after** polling, not before.
- Relink existing nodes (O(1) extra per node) instead of creating new ones.
- The comparator should compare node values; use `Integer.compare` to avoid overflow.
- Same k-way merge pattern solves **Smallest Range Covering K Lists**, **Kth Smallest in a Sorted Matrix**, and **Design Twitter's news feed**.

**How to explain:** "I keep a min-heap with the current front node of every list. I repeatedly take the smallest, add it to the result, and push its successor. With k lists in the heap each step costs O(log k), so the total is O(N log k)."
