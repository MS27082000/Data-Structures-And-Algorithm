# Linked List Cycle: Detect a Loop (LC 141)

**Problem:** Does the linked list contain a cycle?

**Brute force:** Store visited nodes in a `HashSet`. If you see one twice → cycle → O(n) time, **O(n) space**.
**Optimal:** **Floyd's tortoise and hare**: `slow` moves 1, `fast` moves 2. If they ever meet there is a cycle; if `fast` reaches `null` there isn't → O(n) time, **O(1) space**.

**Intuition:** Inside a cycle the fast pointer gains one node on the slow pointer each step, so it must eventually land on it. On a straight list `fast` simply runs off the end.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty list, one node pointing to itself, cycle at the head, no cycle, equal **values** (not a cycle).

**Interview traps**
- Compare **node references** (`==`), never values.
- Loop condition `fast != null && fast.next != null` avoids a `NullPointerException`.
- State the HashSet solution first, then improve to O(1) space.
- Follow-ups: find the start of the cycle (LC 142) and its length.

**How to explain:** "A fast and a slow pointer. If there is a loop the fast one laps the slow one and they meet; otherwise fast reaches the end."
