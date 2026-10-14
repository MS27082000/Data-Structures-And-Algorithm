# Reverse a Stack (using recursion)

**Problem:** Reverse the elements of a stack **without** using any extra data structure (only recursion).

**Brute force:** Pop everything into a queue or array and push back → O(n) time, O(n) extra structure (not allowed).
**Recursive solution:** Two recursive functions:
1. `reverse(stack)`: pop the top, recursively reverse the rest, then `insertAtBottom(stack, top)`.
2. `insertAtBottom(stack, x)`: pop the top, recursively insert `x` at the bottom, push the top back.

**Intuition:** The call stack temporarily holds the elements. The first element removed (the old top) should end up at the bottom, which is exactly what `insertAtBottom` does after the rest is reversed.

**Complexity:** Time O(n²) (n inserts, each O(n)), Space O(n) recursion stack.

**Edge cases:** Empty stack, one element, two elements.

**Interview traps**
- Base case for both functions is an **empty stack**.
- Don't confuse the two functions. The helper `insertAtBottom` is the real trick.
- Same pattern as **Sort a Stack** (recursive `insertInSortedOrder`).
- A recursion depth of n risks a stack overflow for very large stacks.

**How to explain:** "Pop the top, reverse the remaining stack, then insert the popped element at the bottom using another recursive helper."
