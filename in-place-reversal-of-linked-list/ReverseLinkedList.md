# Reverse a Linked List (LC 206)

**Problem:** Reverse a singly linked list and return the new head.

**Brute force:** Copy values into an array and rewrite them in reverse order → O(n) time, O(n) space.
**Optimal (iterative):** Three pointers `prev`, `cur`, `next`. For each node: save `next`, point `cur.next` to `prev`, advance `prev` and `cur` → O(n) time, O(1) space.
**Recursive:** Reverse the rest of the list, then make `head.next.next = head` and `head.next = null` → O(n) time, O(n) stack.

**Intuition:** Each node's pointer just needs to flip direction. You must remember the next node *before* overwriting `cur.next`, or you lose the rest of the list.

**Complexity:** Iterative: O(n) time, O(1) space. Recursive: O(n) time, O(n) space.

**Edge cases:** Empty list, one node, two nodes.

**Interview traps**
- Save `next` **before** changing `cur.next`.
- The new head is `prev` at the end (not `cur`, which is `null`).
- In the recursive version set `head.next = null`, otherwise you create a cycle.
- Interviewers usually ask for **both** versions. This is the base for Reverse in K-Group, Palindrome LL, and Reverse Between.

**How to explain:** "I walk the list once, flipping each node's next pointer to point at the previous node, using three pointers so I never lose the rest of the list."
