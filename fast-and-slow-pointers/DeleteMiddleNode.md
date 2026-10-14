# Delete the Middle Node of a Linked List (LC 2095)

**Problem:** Delete the node at index `floor(n / 2)` (0-indexed) and return the head.

**Brute force:** Count `n`, walk to index `n/2 - 1`, unlink the next node → O(n), two passes.
**Optimal:** Slow/fast, but start `fast` **one step ahead** (`head.next.next`) so `slow` stops on the node **before** the middle → one pass.

**Intuition:** To delete a node in a singly linked list you need its predecessor. Offsetting `fast` by one makes `slow` lag exactly one node behind where it normally would.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** One node (result is empty/null), two nodes (delete the second), three nodes (delete the middle), even length (delete the second-middle).

**Interview traps**
- Handle `head == null || head.next == null` first: the only node is the middle.
- For two nodes, `fast = head.next.next` is `null`, so `slow` stays at the head and removes the second node. Correct.
- Alternative: a `prev` pointer that trails `slow` instead of offsetting `fast`.

**How to explain:** "I run slow/fast with fast starting two ahead, so slow ends just before the middle, then I skip over the middle node."
