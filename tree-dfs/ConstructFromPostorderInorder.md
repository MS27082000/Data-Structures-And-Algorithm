# Construct a Binary Tree from Postorder and Inorder (LC 106)

**Problem:** Rebuild the tree from its inorder and postorder traversals (unique values).

**Key facts**
- **Postorder:** the **last** element is the **root**.
- **Inorder:** elements left of the root are the left subtree; right of it the right subtree.

**Approach:** Same as [Preorder + Inorder](ConstructFromPreorderInorder.md), mirrored:
- `root = post[postHi]`, `rootIn = map[root]`, `leftSize = rootIn − inLo`.
- Left subtree: `post[postLo .. postLo+leftSize−1]`, `in[inLo .. rootIn−1]`.
- Right subtree: `post[postLo+leftSize .. postHi−1]`, `in[rootIn+1 .. inHi]`.
→ O(n) time with a `HashMap` of inorder positions.

**Alternative (single pointer):** Walk postorder **from the back**; the order is Root, Right, Left, so build the **right subtree first**, then the left.

**Complexity:** Time O(n), Space O(n).

**Edge cases:** A single node, left- and right-skewed trees, negative values.

**Interview traps**
- The root is the **last** postorder element (not the first).
- If you use a moving pointer from the back, **build the right subtree before the left**. Doing it the other way round gives a wrong tree.
- Values must be distinct.
- Use ranges, don't slice arrays.

**How to explain:** "The last element of postorder is the root. I find it in inorder to split left and right, use the left size to split postorder, and recurse on both parts."
