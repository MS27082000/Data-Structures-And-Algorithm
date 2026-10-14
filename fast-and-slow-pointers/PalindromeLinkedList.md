# Palindrome Linked List (LC 234)

**Problem:** Is a singly linked list a palindrome?

**Brute force:** Copy values into an array/list and check with two pointers → O(n) time, **O(n) space**. (Or push half onto a stack.)
**Optimal (O(1) space):**
1. Find the middle with slow/fast (slow ends at the **end of the first half**).
2. **Reverse the second half** in place.
3. Compare the first half with the reversed second half.
4. **Restore** the list by reversing the second half again (good practice, since interviewers may ask you not to modify the input).

**Intuition:** A palindrome reads the same from both ends. A singly linked list can't go backwards, so we reverse half of it to read it backwards.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty or one node (true), two nodes, odd length (the middle element is skipped), even length.

**Interview traps**
- The loop `fast.next != null && fast.next.next != null` makes `slow` the **last node of the first half** (not the middle of the whole list).
- For odd lengths the middle node is ignored automatically because `p2` runs over the shorter second half.
- Mention that you restore the list (or note that you mutate it).
- Combines three skills: slow/fast, reverse a list, compare.

**How to explain:** "Find the middle, reverse the second half, compare it with the first half node by node, and finally reverse it back so the list is unchanged."
