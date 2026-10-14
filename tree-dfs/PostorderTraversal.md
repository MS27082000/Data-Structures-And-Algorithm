# Postorder Traversal (LC 145)

**Order:** **Left → Right → Root.** Children are processed **before** their parent, so it suits **deleting a tree, computing heights/sizes bottom-up, and evaluating expression trees**.

**Recursive:** `postorder(left); postorder(right); visit(node)` → O(n) time, O(h) stack.
**Iterative, two stacks (easy):** Produce **Root, Right, Left** (a mirrored preorder using a stack), then **reverse** the result → O(n) time, O(n) space.
**Iterative, one stack (harder):** Dive left; look at the stack top. If its right child exists and **hasn't been visited yet** (`!= lastVisited`), go right. Otherwise visit the node and pop it, remembering it as `lastVisited` → O(n) time, O(h) space.

**Intuition (reverse trick):** Reverse of *Left, Right, Root* is *Root, Right, Left*, which is a preorder that visits the right child first.

**Complexity:** Time O(n), Space O(h) (one stack) or O(n) (two stacks / reversed list).

**Edge cases:** Empty tree, a single node, a node with only a left child (the `top.right == null` case).

**Interview traps**
- The one-stack version needs the **`lastVisited`** pointer to avoid revisiting the right subtree forever.
- With the reverse method, push **left first, then right** (opposite of preorder).
- Postorder is the order used by bottom-up recursion: height, diameter, max path sum, balanced tree.

**How to explain:** "A node can only be visited after both of its subtrees. I can do that with one stack by tracking the last visited node, or by doing a root-right-left walk and reversing it."
