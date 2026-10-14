# Doubly Linked List Fundamentals

Covers 13 sheet items in one file (`DoublyLinkedListBasics.java`): Introduction, Convert Array to DLL, Deletion (head, tail, Kth, a **given node**), Insertion (before head, before tail, before Kth, before a **given node**), Reverse a DLL.

## What it is
Each node has `prev | value | next`. You can walk **both** ways, and given a pointer to a node you can delete it or insert before it in **O(1)** (no need to find its predecessor, unlike a singly linked list). The price: one extra pointer per node and twice the pointer updates.

## Complexity cheat sheet
| Operation | Time | Notes |
|---|---|---|
| Array → DLL | O(n) | Set both `next` and `prev` |
| Delete / insert at head | O(1) | |
| Delete / insert at tail | O(n), or O(1) with a `tail` pointer | |
| Delete / insert at k-th | O(k) to find, O(1) to rewire | |
| **Remove / insert before a given node** | **O(1)** | The big advantage over singly LL |
| Reverse | O(n), O(1) space | Swap `prev` and `next` in every node |

## The rules that avoid every bug
1. Every link change touches **two** pointers: `a.next = b` **and** `b.prev = a`.
2. When removing node `x`: `x.prev.next = x.next` **and** `x.next.prev = x.prev`, guarding the cases `x.prev == null` (head) and `x.next == null` (tail).
3. When inserting `n` before `x`: set `n.prev = x.prev`, `n.next = x`, then fix `x.prev.next = n` (if it exists) and `x.prev = n`.
4. If the head changes, **return the new head**.
5. Test with a forward **and** backward print. A wrong `prev` pointer hides in forward-only output.

## Reverse a DLL
For every node swap `prev` and `next`. The **last** node visited becomes the new head. (The loop moves with `cur = cur.prev` because the pointers were just swapped.)

## Edge cases
Empty list, one node (it is both head and tail), operating on the head or tail, position out of range.

## Interview traps
- Forgetting one of the two pointer updates leaves a broken backward chain.
- Null checks: `node.prev` is null for the head and `node.next` is null for the tail.
- Clear the removed node's pointers (`prev = next = null`) to help GC and avoid accidental reuse.
- Real-world uses: LRU cache (with a hash map), browser history, undo/redo, `LinkedList` in Java.

**How to explain:** "Because each node knows its predecessor, I can delete or insert at a node in constant time. The only care is updating both the next and the prev pointers on each side."
