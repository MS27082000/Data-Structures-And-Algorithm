# Two Sum in a BST (LC 653)

**Problem:** Do two **different** nodes exist whose values sum to `k`?

**Approach 1 (HashSet):** Traverse the tree; for each value check whether `k − value` was seen → O(n) time, O(n) space. Works on any tree, ignores the BST property.
**Approach 2 (inorder list + two pointers):** Inorder into a sorted list, then Two Sum II → O(n) time, O(n) space.
**Optimal space (two controlled inorders):** Use **two iterators**: one yields keys in **ascending** order (left spine stack), the other in **descending** order (right spine stack). Run Two Sum II with them:
- `sum == k` → true; `sum < k` → advance the ascending iterator; `sum > k` → advance the descending one; stop when they meet.
→ O(n) time, **O(h) space**.

**Intuition:** A BST is a sorted array you can read from either end. The two-pointer technique needs only the two ends moving inward.

**Complexity:** Time O(n), Space O(h) (iterator version).

**Edge cases:** A single node (can't pair with itself), empty tree, negative values, the same value needed twice (`k = 2·x` requires two nodes).

**Interview traps**
- The two pointers must be **different nodes**. Stop when they are the same.
- Start with the simple HashSet answer, then offer the O(h)-space iterator version.
- Reuses the **BST Iterator** idea, plus its mirrored (reverse) iterator.

**How to explain:** "I treat the BST as a sorted sequence and use two pointers, one walking from the smallest up and one from the largest down, each implemented as a lazy inorder with a stack. That gives Two Sum in linear time with only O(height) extra memory."
