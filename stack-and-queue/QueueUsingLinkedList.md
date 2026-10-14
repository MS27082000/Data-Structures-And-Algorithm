# Implement a Queue using a Linked List

**Problem:** Build a FIFO queue backed by a singly linked list.

**Approach:** Keep **both `head` and `tail`** pointers.
- `enqueue(x)`: append at the **tail** (`tail.next = node; tail = node`); if the queue was empty, `head = tail = node`.
- `dequeue()`: remove from the **head** (`head = head.next`).

**Why these ends:** Adding at the tail is O(1) only because we keep a `tail` pointer. Removing at the head is O(1). The reverse (add at head, remove at tail) would need an O(n) walk to the second-last node.

**Complexity:** All operations O(1). Space O(n). No capacity limit.

**Edge cases:** Dequeue from an empty queue, dequeue the **last** element, enqueue after the queue becomes empty.

**Interview traps**
- **When `head` becomes `null` after a dequeue, also set `tail = null`.** Otherwise `tail` points to a removed node and the next enqueue is lost.
- First enqueue sets both `head` and `tail`.
- Check `head == null` for dequeue/peek.

**How to explain:** "I keep pointers to both ends of the list. New elements join at the tail and elements leave from the head, so both operations are constant time. After the last element leaves I reset the tail too."
