# Starting Point of a Loop (Linked List Cycle II, LC 142)

**Problem:** Return the node where the cycle begins, or `null` if there is no cycle.

**Brute force:** `HashSet` of visited nodes. The first node seen twice is the start → O(n) time, O(n) space.
**Optimal (Floyd's, 2 phases):**
1. `slow`/`fast` until they meet inside the cycle.
2. Put a pointer at `head`. Move it and `slow` **one step at a time**. They meet exactly at the **cycle start**.

**Why it works (the proof they ask for):** Let `a` = distance from head to the cycle start, `b` = distance from the start to the meeting point, `c` = cycle length. At the meeting `slow` walked `a + b`, `fast` walked `2(a + b)`, and the difference is a whole number of laps: `a + b = k·c`. So `a = k·c - b`: walking `a` steps from the meeting point lands on the cycle start, the same as walking `a` from the head.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Cycle starting at the head, self loop, no cycle, whole list is the cycle.

**Interview traps**
- Reset **one** pointer to `head` (not both) and move both at the **same speed** in phase 2.
- Return the node, not its value (several nodes can share a value).
- Be able to explain the `a + b = k·c` derivation.

**How to explain:** "First find where slow and fast meet. The distance from the head to the cycle start equals the distance from the meeting point to the start, so moving two pointers one step at a time from those places makes them meet at the start."
