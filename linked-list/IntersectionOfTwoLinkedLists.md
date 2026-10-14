# Intersection of Two Linked Lists (LC 160)

**Problem:** Two singly linked lists may merge into a shared tail (a "Y" shape). Return the first shared **node**, or `null`.

**Brute force:** For each node in A, scan all of B → O(m·n).
**Better:**
- `HashSet` of nodes in A, then scan B → O(m + n) time, O(m) space.
- Length difference: find both lengths, advance the longer list by the difference, then walk both together until they meet → O(m + n), O(1) space.
**Optimal (elegant):** Two pointers `a` and `b`. When one reaches the end, it **jumps to the other list's head**. After at most `m + n` steps both have walked the same total distance, so they meet at the intersection (or both reach `null` together when there is none).

**Intuition:** Path of `a` = (A-only part) + (shared) + (B-only part). Path of `b` = (B-only part) + (shared) + (A-only part). Equal lengths → they align at the shared part.

**Complexity:** Time O(m + n), Space O(1).

**Edge cases:** No intersection (return `null`), one list is a suffix of the other, same list, one list empty, intersection at the head.

**Interview traps**
- Compare **nodes** (`==`), not values. Equal values don't mean intersection.
- Let the pointers become `null` before switching (`a == null ? headB : a.next`) so that "no intersection" ends in `a == b == null` and the loop terminates.
- The lists must not be modified and must have no cycles.

**How to explain:** "Each pointer walks its own list and then the other one. They cover the same total distance, so they meet at the intersection node, or both end at null if there is none."
