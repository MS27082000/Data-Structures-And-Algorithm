# Introduction to Binary Search Trees (BST)

## Definition
A **binary search tree** is a binary tree where, for **every node**, all keys in the **left subtree are smaller** and all keys in the **right subtree are larger** than the node's key (keys distinct, unless the problem states a rule for duplicates).

> The rule applies to the **whole subtree**, not just the immediate children. `5 → (1, 4 → (3, 6))` is **not** a BST because `3 < 5` sits in the right subtree.

## The one fact that powers everything
**Inorder traversal of a BST visits keys in sorted (ascending) order.** Kth smallest, validation, two-sum, successor and iterator all use this.

## Complexity
| Operation | Balanced | Skewed (worst) |
|---|---|---|
| Search / Insert / Delete | **O(log n)** | O(n) |
| Min / Max | O(log n) | O(n) |
| Inorder traversal | O(n) | O(n) |

Everything costs **O(h)** where `h` is the height. Inserting **already sorted** data builds a chain (height n). That's why **self-balancing trees** (AVL, Red-Black; Java's `TreeMap`/`TreeSet`) exist.

## Core mechanics
- **Search / insert:** compare with the node; go left if smaller, right if larger. A new key always ends up as a **leaf**.
- **Delete:** leaf → remove; one child → replace with that child; two children → replace with the **inorder successor** (or predecessor), then delete that node.

## BST vs array vs hash map
| | Sorted array | Hash map | BST |
|---|---|---|---|
| Search | O(log n) | O(1) | O(log n) |
| Insert/delete | O(n) | O(1) | O(log n) |
| Ordered iteration, floor/ceil, range queries | easy | hard | **easy** |

## Edge cases
Empty tree, single node, duplicates (decide the rule: ignore, count, or always go right), skewed trees, `Integer.MIN/MAX` keys.

## Interview traps
- "Left < node < right" must hold for **all descendants**, not just children.
- Most operations are O(h), not O(log n). Mention the skewed worst case.
- In Java use `TreeMap`/`TreeSet` (balanced) in real code. Implement BST by hand only to show understanding.

**How to explain:** "A BST keeps smaller keys on the left and larger on the right at every node, so each comparison discards half of the remaining tree. Operations take time proportional to the height, and an inorder walk gives sorted order."
