# Minimum and Maximum in a BST

**Problem:** Find the smallest and the largest key in a BST.

**Brute force:** Traverse every node tracking min and max → O(n).
**Optimal:** The **minimum is the leftmost node** and the **maximum is the rightmost node**. Follow `left` (or `right`) pointers until they run out → O(h), O(1) space.

**Intuition:** Smaller keys always go left and larger keys always go right, so the extremes sit at the ends of those chains. The minimum has **no left child**; the maximum has **no right child**.

**Complexity:** Time O(h), Space O(1).

**Edge cases:** Empty tree (return null), a single node (min = max), left- or right-skewed trees.

**Interview traps**
- The leftmost node may still have a **right** subtree. It's still the minimum (everything in that right subtree is bigger than it but smaller than its parent).
- Don't scan the whole tree. This is the standard "use the BST property" check.
- These helpers are reused: **delete** (inorder successor = min of the right subtree) and **successor/predecessor**.

**How to explain:** "The minimum is the leftmost node and the maximum is the rightmost, so I just keep walking left or right until I can't."
