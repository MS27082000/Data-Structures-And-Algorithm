# Inorder Successor and Predecessor in a BST (LC 285)

**Problem:** The **successor** of a key is the **smallest key greater than it**; the **predecessor** is the **largest key smaller than it**. Return -1 (or `null`) if none.

**Brute force:** Inorder traversal into a list, then find the neighbour → O(n).
**Optimal (O(h), O(1) space):** Walk down from the root.
- **Successor:** if `key < node.val`, the node is a **candidate** (it's larger), so record it and go **left**; otherwise go **right**. The last recorded candidate is the answer.
- **Predecessor:** mirror: if `key > node.val`, record the node and go **right**; otherwise go **left**.

**Case analysis (what the walk finds)**
- If the key has a **right subtree**, the successor is the **leftmost node of that subtree**.
- Otherwise it is the **lowest ancestor for which the key lies in the left subtree**.

**Intuition:** The candidate rule captures both cases in one loop and works even when the key itself isn't in the tree (it returns the next larger key).

**Complexity:** Time O(h), Space O(1).

**Edge cases:** The maximum (no successor), the minimum (no predecessor), the key at the root, a key not in the tree.

**Interview traps**
- Handle **equal** correctly: `key == node.val` means "the successor is strictly larger", so go right.
- Without parent pointers you need the top-down walk; with parent pointers you can climb up.
- Used by **Delete a node** (successor of a two-child node) and **BST Iterator**.

**How to explain:** "I walk from the root toward the key. Every time I turn left, the current node is a bigger key I could return, so I save it. When the walk ends, the last saved node is the successor."
