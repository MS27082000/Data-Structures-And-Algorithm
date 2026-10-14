# Implement a Stack using an Array

**Problem:** Build a LIFO stack backed by an array with `push`, `pop`, `peek`, `isEmpty`, `size`.

**Approach:** A fixed array plus an integer `top` (index of the top element, `-1` when empty).
- `push(x)`: `data[++top] = x`
- `pop()`: `return data[top--]`
- `peek()`: `return data[top]`

**Complexity:** Every operation O(1) time. Space O(capacity).

**Edge cases:** Push on a full stack (**overflow**), pop/peek on an empty stack (**underflow**), capacity 1.

**Interview traps**
- Decide how to signal overflow/underflow (exception vs. error value) and say it.
- `top` starts at `-1`, and `size = top + 1`.
- A fixed array limits capacity. For a dynamic stack, **double the array** when full (amortised O(1)), like `ArrayList`.
- Check for full **before** incrementing `top`.

**How to explain:** "I keep an array and a top index. Push increments top and stores, pop returns the element at top and decrements. Both are O(1), with checks for overflow and underflow."
