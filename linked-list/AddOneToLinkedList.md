# Add One to a Number Represented by a Linked List (LC 369)

**Problem:** A non-negative number stored as a linked list with the **most significant digit first** (`1->2->9` = 129). Add one.

**Brute force:** Convert to an integer, add 1, rebuild. Overflows for long lists.
**Approach 1 (reverse):** Reverse, add 1 with carry from the head, reverse back → O(n) time, O(1) space, 3 passes.
**Approach 2 (recursion):** Recurse to the end. The "+1" enters there and the carry propagates back up → O(n) time, O(n) stack.
**Approach 3 (best, used here):** Find the **last node that is not 9**. Increment it, then set all following nodes (all 9s) to 0. If **all** digits are 9, a new leading `1` is needed (use a sentinel node).

**Intuition:** Adding one only affects the trailing run of 9s (they turn into 0s) and the digit just before it (which grows by one).

**Complexity:** Time O(n), Space O(1) (Approach 3).

**Edge cases:** All 9s (`999` → `1000`, length grows), a single `0` (→ 1), 9 at the end only (`129` → `130`), a 9 in the middle (`1 9 3` → `1 9 4`).

**Interview traps**
- The **all-9s** case needs a new head. A sentinel node with value 0 makes this clean: return the sentinel if it became 1.
- In the recursive version the new head is created **after** the recursion returns, if a carry remains.
- Don't convert to `int` or `long`.

**How to explain:** "Only the trailing 9s and the digit before them change. I find the last non-9 digit, add one to it, zero everything after it, and add a new leading 1 if every digit was 9."
