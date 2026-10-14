# Implement a Stack using a Linked List

**Problem:** Build a LIFO stack backed by a singly linked list.

**Approach:** The **head is the top**. Push creates a node pointing to the old head and makes it the new head. Pop reads the head's value and moves the head forward.

**Why the head, not the tail:** Insert/remove at the head is O(1). At the tail of a singly linked list, removing needs an O(n) walk to the second-last node.

**Complexity:** Push, pop, peek O(1). Space O(n) (one node per element, plus a pointer each). **No fixed capacity.**

**Edge cases:** Pop or peek on an empty stack (**underflow**), single element, push after the stack empties.

**Interview traps**
- Make `push` set `new.next = head` **before** reassigning `head`.
- Handle `head == null` for pop/peek.
- Array vs linked list: array has better cache locality and less memory per element, but a fixed size or occasional resize; the linked list never overflows but allocates per element.
- Keep a `size` counter if `size()` must be O(1).

**How to explain:** "The head of the list is the top of the stack. Push puts a new node in front and pop removes the front node, both in constant time, and there's no capacity limit."
