# Sort a Linked List of 0's, 1's and 2's

**Problem:** A linked list containing only `0`, `1` and `2`. Sort it.

**Brute force:** Generic sort (merge sort) → O(n log n).
**Better (value counting):** Count 0s, 1s, 2s, then overwrite node values → O(n) time, O(1) space, **two passes**, and it modifies data instead of relinking nodes.
**Optimal (relink nodes, one pass):** Keep three dummy-headed lists (zeros, ones, twos). Append each node to the right list, then join them: `zeros → ones → twos`.

**Intuition:** The linked-list version of the Dutch National Flag problem. Moving a node between lists is O(1), so a single pass suffices.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty list, only one value present, missing the `1` list (then `zero.next` must point to the 2s), already sorted.

**Interview traps**
- **Set `two.next = null`** at the end. Otherwise the last node may still point into the old list and form a cycle.
- If the `1`s list is empty, connect `zero.next` directly to the `2`s list (handled by `oneD.next != null ? ... : ...`).
- Ask whether you may change node **values** (counting) or must relink nodes.
- Compare with array Sort Colors (LC 75), which uses three pointers.

**How to explain:** "I split the nodes into three lists by value in one pass, then concatenate them, making sure the final tail points to null."
