# Introduction to Binary Trees

## What it is
A **binary tree** is a hierarchy of nodes where each node has **at most two children** (`left`, `right`). The top node is the **root**; nodes with no children are **leaves**.

## Terminology
| Term | Meaning |
|---|---|
| **Depth** of a node | Edges from the root to it (root = 0) |
| **Height** of a node | Longest path (edges, or nodes, say which!) down to a leaf |
| **Level** | All nodes at the same depth |
| **Subtree** | A node together with all its descendants |
| **Ancestor / descendant** | Any node above / below it on its root path (a node counts as its own in LCA problems) |

## Types of binary trees
| Type | Definition |
|---|---|
| **Full** | Every node has 0 or 2 children |
| **Complete** | All levels full except possibly the last, which is filled **left to right** (heaps) |
| **Perfect** | All internal nodes have 2 children and all leaves share a level (`2^h − 1` nodes) |
| **Balanced** | Heights of the left and right subtrees of **every** node differ by ≤ 1 |
| **Skewed (degenerate)** | Every node has one child: behaves like a linked list (height = n) |
| **BST** | Left subtree < node < right subtree (see the BST section) |

## Useful facts
- A tree with `n` nodes has `n − 1` edges.
- A perfect tree of height `h` has `2^h − 1` nodes and `2^(h−1)` leaves.
- A binary tree with `n` nodes has height between `⌊log₂ n⌋ + 1` (balanced) and `n` (skewed).
- Recursion depth equals the tree height, so a skewed tree of 10⁵ nodes can overflow the stack.

## The three ways to walk a tree
- **DFS:** Preorder (root, left, right), Inorder (left, root, right), Postorder (left, right, root). Use recursion or a stack. O(h) space.
- **BFS:** Level order with a queue. O(w) space.

## Recursion template (almost every tree problem)
```java
int solve(TreeNode node) {
    if (node == null) return BASE;           // 1) base case
    int left = solve(node.left);             // 2) solve the subtrees
    int right = solve(node.right);
    return combine(node.val, left, right);   // 3) combine at this node
}
```

## Interview traps
- Define **height in nodes vs edges** before coding (empty tree = 0 or −1).
- `null` checks first, always.
- "Complete" and "perfect" are different; so are "full" and "balanced".
- Time is almost always O(n) (visit each node once); space is O(h) for DFS and O(w) for BFS.

**How to explain:** "A binary tree is a recursive structure: a node with a left and a right subtree, each of which is itself a binary tree. Almost every tree problem is solved by handling null, solving both subtrees, and combining the results at the current node."
