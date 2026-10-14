# Inorder Traversal (LC 94)

**Order:** **Left → Root → Right.** For a **BST** it visits the values in **sorted order**.

**Recursive:** `inorder(left); visit(node); inorder(right)` → O(n) time, O(h) stack.
**Iterative (explicit stack):** Dive left pushing nodes. When you can't go further left, pop (this is the next node to visit), record it, then move to its **right** child and repeat → O(n) time, O(h) space.
**O(1) space:** [Morris Traversal](MorrisInorder.md).

**Intuition:** Everything in the left subtree comes before the root, and everything in the right subtree after. The stack remembers the path of ancestors still waiting for their turn.

**Complexity:** Time O(n), Space O(h) (O(n) for a skewed tree).

**Edge cases:** Empty tree, a single node, left- or right-skewed trees.

**Interview traps**
- The loop condition is `cur != null || !stack.isEmpty()` (both parts matter).
- After visiting a popped node, set `cur = node.right` (not `node.left`).
- Know inorder's special role: **BST sorted order**, validation, kth smallest, and as one of the two traversals needed to rebuild a tree.

**How to explain:** "I go as far left as possible, pushing nodes on a stack. I pop a node, visit it, then repeat the same process on its right subtree."
