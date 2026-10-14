# Implement a Queue using Stacks (LC 232)

**Problem:** Build a FIFO queue using only stack operations.

**Approach A (costly push):** Keep one stack; on push, move everything to a helper stack, add the new element at the bottom, then move everything back → push O(n), pop O(1).
**Approach B (optimal, used here): two stacks.**
- `in` receives all pushes.
- `out` serves pops/peeks. When `out` is **empty**, pour **all** of `in` into `out`. The order reverses, so the oldest element ends up on top.

**Intuition:** Reversing a stack twice restores the original order, which gives FIFO from two LIFO stacks. Each element is moved from `in` to `out` **at most once**, so the cost is **amortised O(1)**.

**Complexity:** Push O(1). Pop/peek amortised O(1) (worst case O(n) for a single call that triggers a transfer). Space O(n).

**Edge cases:** Pop/peek when both stacks are empty, interleaved push and pop (`out` still has elements, so **don't** transfer), single element.

**Interview traps**
- **Only transfer when `out` is empty.** Transferring while `out` has elements breaks the order.
- `isEmpty` is `in.isEmpty() && out.isEmpty()`.
- Be ready to explain **amortised** analysis: n operations cost O(n) total.
- This is also the standard queue for the "two-stack queue" in functional languages.

**How to explain:** "I push into one stack and pop from another. When the pop stack runs out, I pour the push stack into it, which reverses the order so the oldest element comes out first. Each element is moved at most once, so operations are amortised constant time."
