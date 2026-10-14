# Binary Search Tree (BST)

Source: Striver's A2Z DSA Sheet, Binary Search Trees (15 items). Active recall: open the link, solve from scratch, then check the notes.

## The key facts
1. **BST property:** for every node, left subtree < node < right subtree (all descendants, not just children).
2. **Inorder traversal = sorted order.**
3. Search / insert / delete are **O(h)**: O(log n) if balanced, O(n) if skewed.
4. Use the BST order to **discard half the tree** at each step. If your solution visits everything, you're probably not using the BST.

## Common patterns
| Pattern | Used by |
|---|---|
| Walk down, going left/right by comparison | Search, Insert, Floor/Ceil, LCA, Successor |
| Remember a candidate while walking | Floor, Ceil, Successor, Predecessor |
| Inorder = sorted order | Kth smallest, Validate, Recover, Iterator, Two Sum |
| Bounds `(low, high)` passed down | Validate BST, Construct from Preorder |
| Bottom-up record `{isBST, size, min, max}` | Largest BST in a Binary Tree |

## Theory and Basics
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Introduction to BST](BSTBasics.md) | Theory | Property, complexity, balance | n/a |
| 2 | [Search in a BST](SearchInBST.md) | [LC 700](https://leetcode.com/problems/search-in-a-binary-search-tree/) | Go left or right | O(h) |
| 3 | [Floor and Ceil in a BST](FloorAndCeilInBST.md) | [GfG](https://www.geeksforgeeks.org/problems/floor-in-bst/1) | Remember the candidate | O(h) |
| 4 | [Minimum and Maximum in a BST](MinMaxInBST.md) | [GfG](https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1) | Leftmost / rightmost | O(h) |

## Medium
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 5 | [Insert a Node in a BST](InsertIntoBST.md) | [LC 701](https://leetcode.com/problems/insert-into-a-binary-search-tree/) | New key becomes a leaf | O(h) |
| 6 | [Delete a Node in a BST](DeleteNodeInBST.md) | [LC 450](https://leetcode.com/problems/delete-node-in-a-bst/) | 3 cases, inorder successor | O(h) |
| 7 | [Kth Smallest and Largest](KthSmallestLargest.md) | [LC 230](https://leetcode.com/problems/kth-smallest-element-in-a-bst/) | Stop at the k-th inorder visit | O(h+k) |
| 8 | [Check if a Tree is a BST](ValidateBST.md) | [LC 98](https://leetcode.com/problems/validate-binary-search-tree/) | `(low, high)` bounds | O(n) |
| 9 | [LCA in a BST](LCAInBST.md) | [LC 235](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/) | First split point | O(h) |
| 10 | [Construct a BST from Preorder](ConstructBSTFromPreorder.md) | [LC 1008](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/) | Upper bound + shared index | O(n) |
| 11 | [Inorder Successor and Predecessor](InorderSuccessorPredecessor.md) | [LC 285](https://leetcode.com/problems/inorder-successor-in-bst/) (premium) | Candidate while walking | O(h) |

## FAQs
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 12 | [BST Iterator](BSTIterator.md) | [LC 173](https://leetcode.com/problems/binary-search-tree-iterator/) | Stack of the left spine | O(1) amortised, O(h) space |
| 13 | [Two Sum in a BST](TwoSumInBST.md) | [LC 653](https://leetcode.com/problems/two-sum-iv-input-is-a-bst/) | Ascending + descending iterators | O(n), O(h) space |
| 14 | [Correct a BST with Two Nodes Swapped](RecoverBST.md) | [LC 99](https://leetcode.com/problems/recover-binary-search-tree/) | Find the inorder descents | O(n) |
| 15 | [Largest BST in a Binary Tree](LargestBSTSubtree.md) | [LC 333](https://leetcode.com/problems/largest-bst-subtree/) (premium) | Postorder `{isBST, size, min, max}` | O(n) |

## Related
[Binary tree traversals and the recursion template](../tree-dfs/README.md) · [Level-order problems](../tree-bfs/README.md) · [Binary search](../binary-search/README.md)

## Run any program
```
javac -d out *.java
java -cp out ValidateBST
```
