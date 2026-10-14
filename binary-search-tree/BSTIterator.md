# BST Iterator (LC 173)

**Problem:** Implement an iterator over a BST that returns keys in **ascending order**: `next()` returns the next smallest number and `hasNext()` tells whether any remain.

**Brute force:** Run a full inorder traversal in the constructor and store everything in a list → O(n) memory.
**Optimal (controlled inorder, O(h) memory):** Keep a **stack of the left spine** only.
- **Constructor:** push the root and all its left descendants.
- **`next()`:** pop the top (the smallest unvisited node), then push the **left spine of its right child**. Return its value.
- **`hasNext()`:** `!stack.isEmpty()`.

**Intuition:** It is the iterative inorder traversal frozen mid-way. The stack always holds the nodes whose turn is still to come.

**Complexity:** `next()` and `hasNext()` are **amortised O(1)** (each node is pushed and popped once over n calls), memory **O(h)**.

**Edge cases:** Empty tree (`hasNext()` false), a single node, a right-skewed tree (stack stays small), a left-skewed tree (stack is O(n) at the start).

**Interview traps**
- The LeetCode follow-up asks for **O(h) memory**, which rules out the "store everything" answer.
- Push the left spine of the **right child** after popping.
- Worst case for a single `next()` is O(h), but the amortised cost is O(1).
- The same idea gives a **reverse** iterator (swap left/right), which Two Sum in BST uses.

**How to explain:** "I run an inorder traversal lazily. The stack holds the left spine of the tree; each `next()` pops the smallest node and pushes the left spine of its right subtree, so memory stays proportional to the height."
