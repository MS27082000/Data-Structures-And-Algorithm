# Singly Linked List Fundamentals

Covers 14 sheet items in one file (`SinglyLinkedListBasics.java`): Introduction, Traversal, Deletion, Insertion, Delete head / tail / Kth / value X, Insert at head / tail / Kth / before value X, Length, Search.

## What it is
A chain of nodes `value | next`. Access is by following `next` from the **head**, so there is no random access (O(n) to reach the k-th node). Inserting or deleting after a known node is O(1).

## Complexity cheat sheet
| Operation | Time | Notes |
|---|---|---|
| Array → LL, traversal, length, search | O(n) | One pass |
| Insert at head | O(1) | New node points to the old head |
| Insert at tail | O(n) | O(1) if you keep a `tail` pointer |
| Insert at k-th / before value X | O(k) / O(n) | Walk to the **previous** node |
| Delete head | O(1) | Return `head.next` |
| Delete tail | O(n) | Stop at the **second-last** node |
| Delete k-th / value X | O(k) / O(n) | Walk to the previous node, skip over the target |

## The rules that avoid every bug
1. **Insert/delete needs the previous node.** Walk to it, not to the target.
2. **Head is special.** Inserting or deleting at position 1 changes the head, so these methods **return the new head**.
3. **Order of pointer updates matters.** On insert: `new.next = prev.next` first, **then** `prev.next = new`. Doing it the other way loses the rest of the list.
4. A **dummy node** in front of the head removes the head special case.

## Edge cases
Empty list, one node, deleting the only node, position out of range, value not found, duplicates (delete the first match only here).

## Interview traps
- `NullPointerException` on `t.next.next` when the list has 0 or 1 node. Guard first.
- Deleting by value: handle "the head holds the value" before the loop.
- 1-indexed vs 0-indexed positions. Check the problem statement.
- Mention the trade-off vs arrays: O(1) insert/delete at a known node, but O(n) access.

**How to explain:** "A singly linked list only moves forward, so for any insert or delete I walk to the node before the target and rewire its next pointer, taking care of the head separately."
