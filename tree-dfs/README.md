# Tree DFS (Recursive Family)

Source: Striver's A2Z DSA Sheet, Binary Trees (32 items). The recursive / depth-first family is here (23 items). The level-order family is in [tree-bfs](../tree-bfs/README.md). Active recall: open the link, solve from scratch, then check the notes.

## The recursion template (solves most tree problems)
```java
int solve(TreeNode node) {
    if (node == null) return BASE;           // 1) base case
    int left = solve(node.left);             // 2) solve both subtrees
    int right = solve(node.right);
    // 3) optionally update a global answer using left and right
    return combine(node.val, left, right);   // 4) return what the PARENT needs
}
```
Key idea for Diameter, Max Path Sum, Balanced: **what you return to the parent** differs from **what you record as the answer**.

Complexity: Time O(n), Space O(h) (height; O(n) for a skewed tree).

## Theory and Traversals (6 items)
| # | Question (notes) | Practice | Idea |
|---|---|---|---|
| 1 | [Introduction](TreeBasics.md) | Theory | Terms, types, recursion template |
| 2 | [Inorder](InorderTraversal.md) | [LC 94](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Left, Root, Right (BST = sorted) |
| 3 | [Preorder](PreorderTraversal.md) | [LC 144](https://leetcode.com/problems/binary-tree-preorder-traversal/) | Root, Left, Right |
| 4 | [Postorder](PostorderTraversal.md) | [LC 145](https://leetcode.com/problems/binary-tree-postorder-traversal/) | Left, Right, Root |
| 5 | Level Order | [LC 102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | In [tree-bfs](../tree-bfs/LevelOrderTraversal.md) |
| 6 | [Pre, Post, Inorder in one traversal](PrePostInOneTraversal.md) | [GfG](https://www.geeksforgeeks.org/problems/postorder-traversal-iterative/1) | Stack of (node, state) |

## Medium Problems (7 items)
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 7 | [Maximum Depth](MaximumDepth.md) | [LC 104](https://leetcode.com/problems/maximum-depth-of-binary-tree/) | `1 + max(l, r)` | O(n) |
| 8 | [Identical Trees](IdenticalTrees.md) | [LC 100](https://leetcode.com/problems/same-tree/) | Lockstep DFS | O(n) |
| 9 | [Balanced Binary Tree](BalancedBinaryTree.md) | [LC 110](https://leetcode.com/problems/balanced-binary-tree/) | Height with −1 sentinel | O(n) |
| 10 | [Diameter](DiameterOfBinaryTree.md) | [LC 543](https://leetcode.com/problems/diameter-of-binary-tree/) | `left + right` at every node | O(n) |
| 11 | [Maximum Path Sum](MaxPathSum.md) | [LC 124](https://leetcode.com/problems/binary-tree-maximum-path-sum/) | One-side gain, both-side answer | O(n) |
| 12 | [Symmetrical Trees](SymmetricTree.md) | [LC 101](https://leetcode.com/problems/symmetric-tree/) | Mirror comparison | O(n) |
| 13 | [Children Sum Property](ChildrenSumProperty.md) | [GfG](https://www.geeksforgeeks.org/problems/children-sum-parent/1) | Push down, sum up | O(n) |

## FAQs in this folder (5 of 13)
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 14 | [Boundary Traversal](BoundaryTraversal.md) | [GfG](https://www.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1) | Left edge, leaves, right edge | O(n) |
| 15 | [Root to Leaf Paths](RootToLeafPaths.md) | [LC 257](https://leetcode.com/problems/binary-tree-paths/) | DFS + backtracking | O(n·h) |
| 16 | [LCA in a Binary Tree](LowestCommonAncestor.md) | [LC 236](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/) | Postorder, both sides found | O(n) |
| 17 | [Count Nodes in a Complete Tree](CountCompleteTreeNodes.md) | [LC 222](https://leetcode.com/problems/count-complete-tree-nodes/) | `2^h − 1` for perfect subtrees | O(log² n) |
| 18 | [Flatten Binary Tree to Linked List](FlattenBinaryTree.md) | [LC 114](https://leetcode.com/problems/flatten-binary-tree-to-linked-list/) | Hang right subtree on the left's rightmost | O(n), O(1) space |

(The other FAQs: Zig Zag, Vertical Order, Top View, Bottom View, Right/Left View, Maximum Width, Nodes at Distance K and Burning the Tree are in [tree-bfs](../tree-bfs/README.md).)

## Construction Problems (4 items)
| # | Question (notes) | Practice | Idea |
|---|---|---|---|
| 19 | [Requirements for a unique tree](UniqueTreeRequirements.md) | Theory | Inorder + another order |
| 20 | [Preorder + Inorder](ConstructFromPreorderInorder.md) | [LC 105](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/) | Root = first of preorder |
| 21 | [Postorder + Inorder](ConstructFromPostorderInorder.md) | [LC 106](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/) | Root = last of postorder |
| 22 | [Serialize and Deserialize](SerializeDeserializeBinaryTree.md) | [LC 297](https://leetcode.com/problems/serialize-and-deserialize-binary-tree/) | Preorder with `#` markers |

## Traversal in Constant Space (2 items)
| # | Question (notes) | Practice | Idea |
|---|---|---|---|
| 23 | [Morris Inorder](MorrisInorder.md) | [LC 94](https://leetcode.com/problems/binary-tree-inorder-traversal/) | Threads via the predecessor |
| 24 | [Morris Preorder](MorrisPreorder.md) | [LC 144](https://leetcode.com/problems/binary-tree-preorder-traversal/) | Record on the first arrival |

## Run any program
```
javac -d out *.java
java -cp out MaxPathSum
```
