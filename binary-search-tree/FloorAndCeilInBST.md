# Floor and Ceil in a BST

**Problem:** For a value `x`, the **floor** is the **largest key ≤ x** and the **ceil** is the **smallest key ≥ x**. Return -1 if it doesn't exist.

**Brute force:** Inorder traversal into a sorted list, then scan or binary search → O(n) time and space.
**Optimal (one downward walk, O(h), O(1) space):**
- **Floor:** if `node.val == x` return it. If `node.val < x` it is a **candidate**, so remember it and go **right** (maybe something larger but still ≤ x). Otherwise go **left**.
- **Ceil:** mirror image: if `node.val > x` it's a candidate, remember it and go **left**; otherwise go **right**.

**Intuition:** This is Floor/Ceil from binary search, with the BST path playing the role of the search range. The last remembered candidate is the closest one.

**Complexity:** Time O(h), Space O(1).

**Edge cases:** `x` smaller than every key (floor = -1), larger than every key (ceil = -1), exact match, empty tree.

**Interview traps**
- **Record the candidate before moving.** Many solutions forget to save it and lose the answer when the path ends at `null`.
- Floor goes **right** after a candidate; ceil goes **left**.
- If -1 is a valid key, use a sentinel/`Integer` instead.

**How to explain:** "I walk down the tree. Whenever a node is a valid floor (or ceil) I remember it and keep looking in the direction where a closer one could exist. The last remembered node is the answer."
