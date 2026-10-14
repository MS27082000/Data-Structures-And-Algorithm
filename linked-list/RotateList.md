# Rotate List (LC 61)

**Problem:** Rotate a linked list to the **right** by `k` places.

**Brute force:** Rotate by one `k` times (move the last node to the front) → O(n·k).
**Optimal:**
1. Find the length `len` and the **tail**.
2. `k %= len`. If `k == 0`, nothing to do.
3. Link the tail to the head (**circular**).
4. Walk `len - k` nodes from the head to find the **new tail**; the next node is the **new head**. Break the circle there.

**Intuition:** Rotating right by `k` means the last `k` nodes move to the front. Making the list circular lets you cut at the right place with no shifting.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty list, one node, `k = 0`, `k` multiple of the length, `k` larger than the length.

**Interview traps**
- **Always `k %= len`**. `k` can be huge.
- New tail is at position `len - k` (1-indexed). Off-by-one errors are common, so dry-run with `[1,2,3,4,5], k = 2`.
- **Set `newTail.next = null`**, otherwise the list stays circular.
- Left rotation is the same with `len - k`.

**How to explain:** "I join the tail to the head to make a ring, walk len − k steps to find the new tail, and cut the ring after it. The next node is the new head."
