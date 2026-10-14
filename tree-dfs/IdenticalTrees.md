# Check if Two Trees are Identical (Same Tree, LC 100)

**Problem:** Two binary trees are identical if they have the **same structure** and the **same node values**.

**Approach (simultaneous DFS):** Compare the two roots:
- both `null` → `true`
- exactly one `null` → `false`
- values differ → `false`
- otherwise the left subtrees must be identical **and** the right subtrees must be identical.

**Alternative:** Serialise both trees (preorder with null markers) and compare the strings. It's O(n) but uses extra space.

**Intuition:** Two trees are the same exactly when their roots match and their corresponding children are the same trees, which is a naturally recursive definition.

**Complexity:** Time O(min(n, m)) (stops at the first mismatch), Space O(h).

**Edge cases:** Both empty (true), one empty (false), same values in a different shape (`[1,2]` vs `[1,null,2]`), same shape with different values.

**Interview traps**
- **Check both-null before either-null**, or you'll dereference `null`.
- Same values is not enough. **Shape matters**. A common wrong answer is comparing inorder only.
- Building block for **Subtree of Another Tree** (LC 572) and **Symmetric Tree**.

**How to explain:** "I walk both trees in lockstep. If both nodes are null they match, if only one is null or the values differ they don't, and otherwise I check the left pair and the right pair."
