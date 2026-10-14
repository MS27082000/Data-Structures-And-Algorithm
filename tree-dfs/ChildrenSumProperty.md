# Children Sum Property in a Binary Tree

**Property:** For every non-leaf node, `node.val == left.val + right.val` (a missing child counts as 0; a leaf always satisfies it).

**Problem:** Modify the tree **by only increasing node values** so that the property holds everywhere.

**Approach (one DFS, two phases):**
1. **Going down:** if `childSum < node.val`, **raise both children to `node.val`** (push the parent's value down so no node ever needs to decrease).
2. **Coming back up:** after fixing the children, set `node.val = left.val + right.val` (it is now `>=` the old value).
Leaves keep their (possibly raised) values.

**Intuition:** If the children can't reach the parent's value, increase them. If they exceed it, increase the parent. Pushing down first guarantees the upward sums are never smaller than the original value, so we never need to decrease anything.

**Complexity:** Time O(n), Space O(h).

**Edge cases:** Already valid (unchanged), a node with one child, leaves, a single node.

**Interview traps**
- **Only increments are allowed.** Don't set a parent lower than its original value.
- Compute the child sum with null checks (`left != null ? ... : 0`).
- Update **after** the recursive calls for the upward phase.
- Provide a **checker** (`isChildrenSum`) to test your answer. Ask whether the problem wants to check the property or to fix the tree.

**How to explain:** "On the way down I raise the children to the parent's value if their sum is too small; on the way up I set each node to the sum of its children. That makes the property hold using only increments."
