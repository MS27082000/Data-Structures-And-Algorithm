# Implement a Stack using Queues (LC 225)

**Problem:** Build a LIFO stack using only queue operations (`offer`, `poll`, `peek`, `size`, `isEmpty`).

**Approach A (two queues):** On push, enqueue into an empty `q2`, move everything from `q1` behind it, then swap the queues. Pop/top just use `q1`'s front.
**Approach B (one queue, used here):** On push, enqueue `x`, then **rotate** the previous `n − 1` elements: dequeue each and enqueue it again. Now `x` is at the **front**, which is the stack top.

**Costs (choose where the work goes):**
- *Push-heavy-cost version (here):* push **O(n)**, pop/top **O(1)**.
- *Pop-heavy-cost version:* push O(1), pop O(n) (rotate `n − 1` elements to reach the last one).

**Intuition:** A queue's front is its oldest element. To make the newest element the front, cycle every older element behind it.

**Complexity:** Push O(n), pop O(1), top O(1). Space O(n).

**Edge cases:** Single element, pop until empty, push after emptying.

**Interview traps**
- **Rotate `size − 1` times** (after adding `x`), not `size` times (that would put `x` at the back again).
- Only use queue operations. Don't peek at the back or index into it.
- Know the trade-off: you can't make both push and pop O(1) with only queues.
- Follow-up is the reverse: [Queue using Stacks](QueueUsingStacks.md).

**How to explain:** "After pushing a new element I rotate all the older ones behind it, so the newest element is always at the front. Pop and top then work directly on the queue's front."
