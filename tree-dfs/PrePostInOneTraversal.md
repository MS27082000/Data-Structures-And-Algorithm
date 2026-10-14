# Preorder, Inorder and Postorder in ONE Traversal

**Problem:** Compute all three traversals with a **single pass** over the tree instead of three.

**Approach:** Keep a stack of `(node, state)`. Each node is pushed with a state that says how many times we have been to it:
| State | Meaning | Action |
|---|---|---|
| **1** | First arrival | Add to **preorder**; set state 2; go to the **left** child |
| **2** | Back from the left subtree | Add to **inorder**; set state 3; go to the **right** child |
| **3** | Back from the right subtree | Add to **postorder**; pop (done) |

**Intuition:** A recursive DFS passes through each node three times: before going left, between the subtrees, and after the right. The state number simulates exactly those three moments on an explicit stack.

**Complexity:** Time O(n) (three visits per node, about 3n steps), Space O(n).

**Edge cases:** Empty tree (three empty lists), a single node, skewed trees.

**Interview traps**
- Push the node **back** with its next state **before** pushing the child, since the stack is LIFO.
- Only push a child if it isn't `null`.
- It's a great answer to "can you get all three orders in one pass?"

**How to explain:** "Every node is passed three times in a DFS. I tag each stack entry with 1, 2 or 3 to know which visit this is, and record the value into the preorder, inorder or postorder list accordingly."
