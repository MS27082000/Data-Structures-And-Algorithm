# Reverse Nodes in k-Group (LC 25)

**Problem:** Reverse the list `k` nodes at a time. If fewer than `k` nodes remain at the end, leave them as they are.

**Brute force:** Copy values to an array, reverse each block of `k`, rewrite → O(n) time, O(n) space (and you only changed values, not nodes).
**Optimal (O(1) space):** For each group:
1. Check there are `k` nodes (`getKth`). If not, stop.
2. Reverse those `k` nodes in place (standard reversal, with `prev` starting at the **next group's head** so the tail links forward automatically).
3. Reconnect: the previous group's tail points to the new group head (the old `kth`), and the old group head becomes the new `groupPrev`.

**Intuition:** It's "reverse a linked list" applied to windows, plus careful reconnection between windows. A dummy node simplifies the first group.

**Complexity:** Time O(n), Space O(1). (Recursive version uses O(n/k) stack.)

**Edge cases:** `k = 1` (no change), `k = n` (full reverse), `k > n` (no change), `n` not a multiple of `k`.

**Interview traps**
- **Check for `k` nodes before reversing.** Reversing a short last group would be wrong.
- Starting `prev = groupNext` links the reversed group's tail to the next group without extra code.
- Keep track of `groupPrev` (the tail of the previous reversed group). Losing it breaks the links.
- Use a **dummy head** so the first group needs no special case.

**How to explain:** "I process the list in blocks of k: confirm k nodes exist, reverse them in place, and splice the reversed block between the previous block's tail and the next block's head."
