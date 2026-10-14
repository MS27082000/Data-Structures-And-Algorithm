# Morris Preorder Traversal

**Problem:** Preorder (Root, Left, Right) with **O(1) extra space**.

**Idea:** Exactly the same threading as [Morris Inorder](MorrisInorder.md). The only difference is **when the node is recorded**.

**Algorithm:** `cur = root`. While `cur != null`:
- **No left child:** record `cur`, go **right**.
- **Has a left child:** find `pred` (rightmost node of the left subtree, stopping if `pred.right == cur`).
  - `pred.right == null` → **record `cur` now** (first arrival, root before its left subtree), create the thread `pred.right = cur`, go **left**.
  - `pred.right == cur` → remove the thread and go **right** (do **not** record again).

**Intuition:** Preorder visits a node on the way **down** (first arrival); inorder visits it on the way **back** (second arrival). The threading is the same.

**Complexity:** Time O(n), Space O(1).

**Edge cases:** Empty tree, no left children, a skewed tree, re-running to confirm the tree is restored.

**Interview traps**
- Record on the **first** arrival (when creating the thread), not the second.
- Remove the thread on the second arrival, or the tree stays corrupted.
- Mention Morris **postorder** exists but is much more complicated (usually via a reversed right-first preorder).

**How to explain:** "It's the Morris inorder algorithm, but I record a node when I first reach it, before descending into its left subtree, and use the thread only to come back."
