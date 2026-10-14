# Requirements Needed to Construct a Unique Binary Tree (Theory)

**Question:** Which traversal sequences are enough to rebuild exactly one binary tree?

| Given | Unique tree? | Why |
|---|---|---|
| **Inorder + Preorder** | **Yes** | Preorder's first element is the root; inorder tells which nodes lie left and right of it. Repeat recursively. |
| **Inorder + Postorder** | **Yes** | Postorder's **last** element is the root; inorder splits left and right. |
| **Preorder + Postorder** | **No** (for general trees) | Doesn't say whether a lone child is a left or a right child. |
| Preorder alone / Postorder alone / Inorder alone | No | Many shapes share the same sequence. |
| **Level order + Inorder** | Yes | Level order's first element is the root, and so on. |

## Counter-example (preorder + postorder)
- Tree A: `1` with **left** child `2` → pre `[1,2]`, post `[2,1]`
- Tree B: `1` with **right** child `2` → pre `[1,2]`, post `[2,1]`
Same preorder and postorder, different trees. The **inorder differs** (`[2,1]` vs `[1,2]`), which is why inorder is the key ingredient.

**Exception:** For a **full** binary tree (every node has 0 or 2 children), preorder + postorder **is** unique.

**Other facts**
- For a **BST**, **preorder alone** (or postorder alone) is enough, because inorder is just the sorted values.
- **Values must be distinct** for the standard reconstruction (you look up the root in inorder).

**Interview traps**
- **Inorder is required** (together with preorder, postorder or level order) for a general tree.
- Preorder + postorder can still be asked for **full** trees.
- Always mention the **distinct values** assumption.

**How to explain:** "Inorder tells me what is on each side of a root, and preorder, postorder or level order tell me which node is the root. Preorder with postorder can't tell left children from right children, so it isn't enough for general trees."
