# Remove Nth Node From End of List (LC 19)

**Problem:** Remove the n-th node counting from the **end** and return the head.

**Brute force:** Pass 1: count the length `L`. Pass 2: walk to node `L - n` and unlink the next one → O(n), two passes.
**Optimal (one pass, two pointers):** Move `fast` `n` steps ahead. Then move `fast` and `slow` together until `fast` is on the **last** node. `slow` is then just before the node to delete.

**Intuition:** Keeping a gap of `n` between the pointers means that when `fast` hits the end, `slow` is `n` nodes from the end.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Removing the head (`n == length`), single node, `n = 1` (the tail), two nodes.

**Interview traps**
- Use a **dummy node** before the head, so removing the first node needs no special case.
- Stop when `fast.next == null` (not `fast == null`), so `slow` stays one node **before** the target.
- Start both `fast` and `slow` at the dummy.
- Assume `n` is valid (ask about invalid `n`).

**How to explain:** "I give the fast pointer a head start of n nodes. When it reaches the end, the slow pointer is right before the node to remove, so I skip over it."
