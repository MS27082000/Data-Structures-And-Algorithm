# Middle of the Linked List (LC 876)

**Problem:** Return the middle node. For an even length, return the **second** middle.

**Brute force:** Count the length `n`, then walk `n / 2` steps → O(n) time, two passes.
**Optimal:** **Slow/fast pointers**: `slow` moves 1 step, `fast` moves 2. When `fast` reaches the end, `slow` is at the middle → one pass.

**Intuition:** `fast` covers twice the distance of `slow`, so when `fast` finishes, `slow` is halfway.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** One node, two nodes (returns the 2nd), odd vs even length.

**Interview traps**
- Loop condition: `fast != null && fast.next != null` (check `fast` first).
- This gives the **second** middle for even lengths. For the **first** middle, start `fast = head.next` (this is also what Sort List and Palindrome use to split).
- This helper is the building block for Palindrome LL, Sort List, Delete Middle.

**How to explain:** "Two pointers, one twice as fast. When the fast one hits the end, the slow one is in the middle."
