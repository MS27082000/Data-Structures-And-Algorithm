# Kth Smallest and Kth Largest Element in a BST (LC 230)

**Problem:** Return the `k`-th smallest (or largest) key in a BST.

**Brute force:** Inorder traversal into a list, then index `k − 1` → O(n) time, O(n) space.
**Optimal:** **Inorder visits keys in ascending order.** Do an iterative inorder and **stop at the k-th visited node** → O(h + k) time, O(h) space.
**Kth largest:** run a **reverse inorder** (right → node → left), which visits keys in descending order. The k-th visit is the answer. (Or kth largest = `(n − k + 1)`-th smallest.)

**Intuition:** A BST is a sorted list in disguise. The order-statistic is just "walk the sorted order and count".

**Complexity:** Time O(h + k), Space O(h).

**Edge cases:** `k = 1`, `k` equal to the number of nodes, `k` out of range, a skewed tree.

**Interview traps**
- **Stop early** instead of collecting the whole traversal.
- For repeated queries on a tree that changes, store the **subtree size** in each node for O(h) queries (the LeetCode follow-up).
- Kth largest: reverse the traversal direction, don't recompute from scratch.
- Use `k` as a countdown counter, so no extra list is needed.

**How to explain:** "An inorder walk of a BST gives sorted order, so I walk it with a stack and stop at the k-th node. For the k-th largest I walk it right-to-left."
