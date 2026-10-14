# Length of the Loop in a Linked List

**Problem:** If the list has a cycle, return the number of nodes in the cycle; otherwise 0.

**Brute force:** `HashMap` node → step index. When a node repeats, length = current step − first-seen step → O(n) time and space.
**Optimal:** Floyd's to find a meeting point **inside** the cycle, then walk around the cycle once from there counting nodes until you return to the meeting point → O(n) time, O(1) space.

**Intuition:** Any node where `slow` and `fast` meet is on the cycle. Walking from it until you return to it counts exactly one lap.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** No cycle (0), a self loop (1), the entire list being the cycle, a long tail before the cycle.

**Interview traps**
- Start the count at **1** (the meeting node itself) and step `cur = slow.next`, or you're off by one.
- Compare references, not values.
- It is **not** the list length. Don't count the tail that leads into the cycle.

**How to explain:** "Find where the two pointers meet. That node is in the loop, so I walk around it once, counting nodes until I'm back where I started."
