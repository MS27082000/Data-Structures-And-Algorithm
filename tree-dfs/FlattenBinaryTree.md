# Flatten Binary Tree to Linked List (LC 114)

**Problem:** Rewire the tree **in place** so that it becomes a "linked list" along the **right** pointers, in **preorder**, with every `left` set to `null`.

**Brute force:** Do a preorder traversal into a list, then relink → O(n) time, O(n) space.
**Recursive (reverse preorder):** Process **right**, then **left**, keeping a `prev` pointer; set `node.right = prev`, `node.left = null`, `prev = node` → O(n), O(h) stack.
**Optimal (O(1) space, Morris-like):** For each node `cur` that has a left child:
1. Find the **rightmost node** of `cur.left`.
2. Attach `cur.right` to that rightmost node's `right`.
3. Move `cur.left` to `cur.right`, and set `cur.left = null`.
4. Continue with `cur = cur.right`.
→ O(n) time, O(1) space.

**Intuition:** In preorder, the whole left subtree is visited right after the node and before its right subtree. So the right subtree should hang off the **end** of the left subtree.

**Complexity:** Time O(n), Space O(1) (iterative), O(h) (recursive).

**Edge cases:** Empty tree, no left children (already flat), only left children, a single node.

**Interview traps**
- **Set `left = null`.** Forgetting it leaves a malformed list.
- Attach the old right subtree **before** moving the left subtree over.
- Don't confuse with converting a **BST to a sorted list** (that's inorder).
- The recursive version relies on visiting in **right → left** order.

**How to explain:** "For each node with a left child I find the rightmost node of the left subtree, attach the node's right subtree there, and move the left subtree to the right. Repeating this down the right spine flattens the tree into preorder."
