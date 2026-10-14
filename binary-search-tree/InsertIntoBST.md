# Insert a Given Node into a BST (LC 701)

**Problem:** Insert a new value so the result is still a valid BST. Any valid result is accepted.

**Approach:** The new key **always becomes a leaf**. Walk down comparing with each node (left if smaller, right if larger) until you hit a `null` link, and attach the new node there.

**Recursive:** `if (root == null) return new Node(val); if (val < root.val) root.left = insert(root.left, val); else root.right = insert(root.right, val); return root;`
**Iterative:** walk down, remembering the node whose child slot is empty, then attach → O(1) space.

**Intuition:** Searching for the key fails at exactly the spot where it belongs. Insertion is "search, then plant the node where the search ended".

**Complexity:** Time O(h), Space O(h) recursive / O(1) iterative.

**Edge cases:** Insert into an empty tree (the new node is the root), a key bigger than all or smaller than all, duplicates (state the rule; LeetCode guarantees distinct).

**Interview traps**
- **Return the root.** Recursive solutions reassign `root.left = insert(...)`, so each call must return its subtree's root.
- Inserting sorted data repeatedly produces a skewed tree. Mention balancing (AVL / Red-Black).
- Don't restructure the tree. A leaf insertion is enough.

**How to explain:** "I search for where the value would be. The search ends at an empty child link, and I attach the new node there as a leaf."
