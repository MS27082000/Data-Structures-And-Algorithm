# Morris Inorder Traversal

**Problem:** Inorder traversal using **O(1) extra space** (no recursion stack, no explicit stack).

**Idea:** Temporarily modify the tree with **threads**: make the **inorder predecessor** of a node point back to it, so we can climb back up without a stack. Remove the thread when done, so the tree is **restored**.

**Algorithm:** `cur = root`. While `cur != null`:
- **No left child:** visit `cur`, go **right** (this may follow a thread back to an ancestor).
- **Has a left child:** find `pred` = the **rightmost node of the left subtree** (stop if `pred.right == cur`).
  - `pred.right == null` → **create the thread** (`pred.right = cur`), then go **left**.
  - `pred.right == cur` → the left subtree is done: **remove the thread** (`pred.right = null`), **visit `cur`**, go **right**.

**Intuition:** The thread is a "bookmark" that says "come back here after the left subtree". It replaces the stack.

**Complexity:** Time O(n) (every edge is traversed at most about 3 times), Space **O(1)**.

**Edge cases:** Empty tree, no left children, a skewed tree, running it twice (the tree must come back unchanged).

**Interview traps**
- The inner loop `while (pred.right != null && pred.right != cur)` must stop at **either** condition.
- **Remove the thread** before moving on. A forgotten thread creates a cycle.
- Morris **mutates the tree temporarily**, so it isn't safe if other threads read the tree concurrently.
- Visit `cur` at the **second** arrival for inorder (first arrival for preorder).

**How to explain:** "I link the predecessor of each node back to the node so I can return after finishing the left subtree. That removes the need for a stack, and I cut the link on the way back so the tree is restored."
