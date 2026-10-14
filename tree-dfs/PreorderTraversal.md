# Preorder Traversal (LC 144)

**Order:** **Root → Left → Right.** The root is processed **before** its subtrees, so it is the natural order for **copying or serialising** a tree.

**Recursive:** `visit(node); preorder(left); preorder(right)` → O(n) time, O(h) stack.
**Iterative:** Push the root. Repeatedly **pop**, **visit**, push the **right** child, then the **left** child (right first, so left is popped first) → O(n) time, O(h) space.
**O(1) space:** [Morris Preorder](MorrisPreorder.md).

**Intuition:** A stack is last-in-first-out. Pushing right before left makes the left child come out next, which matches Root, Left, Right.

**Complexity:** Time O(n), Space O(h).

**Edge cases:** Empty tree (don't push `null`), a single node, skewed trees.

**Interview traps**
- **Push right first, then left.** The reverse gives Root, Right, Left.
- Skip `null` children instead of pushing them.
- Preorder's first element is always the root, which is what [Construct from Preorder and Inorder](ConstructFromPreorderInorder.md) uses.

**How to explain:** "I use a stack. I pop a node, visit it, and push its right child and then its left child so the left subtree is processed first."
