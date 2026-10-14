# Implement a Queue using an Array

**Problem:** Build a FIFO queue backed by an array with `enqueue`, `dequeue`, `peek`, `isEmpty`, `size`.

**Naive approach (flawed):** `front` and `rear` indices that only move right. After a few dequeues the front slots are wasted, and the queue reports "full" while the array is mostly empty.
**Optimal:** A **circular buffer**. Keep `front` and `size`. The next free slot is `(front + size) % capacity`; dequeue moves `front = (front + 1) % capacity`.

**Intuition:** Treat the array as a ring so freed slots at the front are reused.

**Complexity:** Every operation O(1) time. Space O(capacity).

**Edge cases:** Full queue, empty queue, wrap-around (enqueue after dequeues), capacity 1.

**Interview traps**
- **Tracking `size` separately** removes the classic ambiguity where `front == rear` means both "empty" and "full".
- Always use `% capacity` for both enqueue and dequeue.
- Check full/empty **before** modifying state.
- For a growing queue, resize by copying elements **in order starting from `front`**, not by a plain array copy.

**How to explain:** "The array is a ring. A front index and a size tell me where the first element is and where the next free slot is, so enqueue and dequeue are O(1) and freed space is reused."
