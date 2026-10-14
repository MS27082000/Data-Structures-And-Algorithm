# Check if an Array Represents a Min Heap

**Problem:** Given an array, does it satisfy the min-heap property in the standard array layout?

**Approach:** For every **internal node** `i` from `0` to `(n − 2) / 2` verify `a[i] <= a[2i + 1]` and, if it exists, `a[i] <= a[2i + 2]` → O(n) time, O(1) space.

**Why only internal nodes:** Leaves have no children, so there is nothing to check. Checking parent ≤ child at every parent is enough, since the ordering then follows transitively down every path.

**Intuition:** The heap property is purely local (parent vs child). The array layout gives you the children for free.

**Complexity:** Time O(n), Space O(1) (iterative).

**Edge cases:** Empty array and one element (valid), equal values (`≤` allows them), a node with only a left child.

**Interview traps**
- Loop bound is `(n − 2) / 2` (the last parent), **not** `n`. Otherwise you index out of range.
- Always check `2i + 2 < n` before reading the right child.
- Use `>` for the violation test (`a[i] > a[l]`), so duplicates are accepted.
- Don't compare siblings with each other. They need no relation.
- The max-heap check is identical with the comparison flipped.

**How to explain:** "I walk through every node that has children and check that it's not larger than its left or right child. If no parent violates the rule, the array is a valid min-heap."
