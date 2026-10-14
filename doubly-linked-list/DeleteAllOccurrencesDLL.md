# Delete All Occurrences of a Key in a Doubly Linked List

**Problem:** Remove every node whose value equals `key` from a doubly linked list. Return the head.

**Brute force:** Rebuild a new list skipping `key` → O(n) time, O(n) space.
**Optimal:** One pass, unlinking in place. Because every node knows its `prev`, each deletion is O(1) → O(n) time, O(1) space.

**Steps:** For each `cur` (save `next = cur.next` first): if `cur.val == key`:
- If `cur.prev != null`: `cur.prev.next = cur.next`; else the head moves: `head = cur.next`.
- If `cur.next != null`: `cur.next.prev = cur.prev`.

**Intuition:** Deleting in a DLL never needs a search for the predecessor. Just connect the two neighbours.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Key at the head, at the tail, several adjacent keys, every node is the key (result empty), key absent, empty list.

**Interview traps**
- **Save `next` before unlinking**, or you lose your place.
- **Update the head** when the removed node is the head.
- Fix **both** the `next` of the previous node and the `prev` of the next node.
- Adjacent duplicates (`2,2,10`) work because we always continue from the saved next.

**How to explain:** "I scan once. When a node matches, I connect its previous and next nodes to each other, moving the head if needed. Having `prev` makes each removal constant time."
