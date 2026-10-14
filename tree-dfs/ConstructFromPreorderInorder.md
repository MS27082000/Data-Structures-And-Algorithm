# Construct a Binary Tree from Preorder and Inorder (LC 105)

**Problem:** Given the preorder and inorder traversals of a tree with **unique** values, rebuild the tree.

**Key facts**
- **Preorder:** the first element is the **root**.
- **Inorder:** the elements **left of the root** form the left subtree; those **right of it** form the right subtree.

**Brute force:** Search the root in inorder with a linear scan each time → O(n²).
**Optimal:** Put `value → inorder index` in a **HashMap** (O(1) lookup). Recurse with index ranges instead of copying arrays:
- `root = pre[preLo]`, `rootIn = map[root]`, `leftSize = rootIn − inLo`.
- Left subtree: `pre[preLo+1 .. preLo+leftSize]`, `in[inLo .. rootIn−1]`.
- Right subtree: `pre[preLo+leftSize+1 .. preHi]`, `in[rootIn+1 .. inHi]`.
→ O(n) time, O(n) space.

**Intuition:** The size of the left subtree (from inorder) tells you how many of the following preorder elements belong to it.

**Complexity:** Time O(n), Space O(n) (map + recursion).

**Edge cases:** A single node, a left-skewed tree, a right-skewed tree, negative values.

**Interview traps**
- **Distinct values** are required (the map would be ambiguous otherwise).
- Compute the **left subtree's size from inorder**, and use it to slice **preorder** correctly. Off-by-one errors live here.
- Pass index ranges. **Don't copy subarrays** (O(n²)).
- Sister problem: [Postorder + Inorder](ConstructFromPostorderInorder.md).

**How to explain:** "The first preorder element is the root. I find it in inorder using a hash map; everything to its left is the left subtree, and the number of those nodes tells me which part of preorder belongs to the left subtree. I recurse on both halves."
