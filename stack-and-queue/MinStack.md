# Min Stack (LC 155)

**Problem:** Design a stack that supports `push`, `pop`, `top` and **`getMin` in O(1)**.

**Brute force:** Scan for the minimum on `getMin` → O(n).
**Approach 1 (two stacks, O(n) extra space):** Alongside the main stack keep a second stack whose top is the **minimum of all elements at or below** the current one. Push `min(x, mins.top)` every time; pop both together.
**Approach 2 (O(1) extra space, encoding trick):** Keep a single `min` variable. Store `x − min` on the stack. A **negative** stored value marks that `x` was a new minimum, and the old minimum is recovered as `min − stored` on pop. Use `long` to avoid overflow.

**Intuition:** The minimum only changes when a smaller element is pushed or the current minimum is popped. Each element can remember "the minimum below me".

**Complexity:** All operations O(1). Space O(n) (two stacks) or O(1) extra (encoding).

**Edge cases:** Duplicate minimums (`push 2, 2, pop` must keep min 2), popping the minimum, `Integer.MIN_VALUE`/`MAX_VALUE`.

**Interview traps**
- Pop from **both** stacks together.
- With duplicates, push to the min-stack when `x <= currentMin` (in the compressed variant) or push `min(x, top)` always (simple variant).
- The encoding trick needs `long` because `x − min` can overflow `int`.
- Variants: Max Stack, `getMin` plus `getMax`.

**How to explain:** "Every element remembers the minimum at the time it was pushed, using a parallel stack. So the current minimum is always on top of that stack and popping restores the previous minimum."
