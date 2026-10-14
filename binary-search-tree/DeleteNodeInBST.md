# Delete a Node in a BST (LC 450)

**Problem:** Delete the node with a given key and keep the tree a valid BST. Return the root.

**Approach:** Find the node (go left/right by comparison), then handle **three cases**:
| Case | Action |
|---|---|
| **Leaf** (no children) | Remove it (return `null`) |
| **One child** | Replace the node with that child (return the child) |
| **Two children** | Replace the node's **value** with its **inorder successor** (the smallest value in the right subtree), then **delete that successor** from the right subtree |

(The inorder **predecessor**, the largest in the left subtree, works equally well.)

**Intuition:** The successor is the next larger key, so it is bigger than everything on the left and no larger than anything on the right. Putting it in the deleted node's place keeps the BST property. The successor has **no left child**, so removing it is a simple case.

**Complexity:** Time O(h), Space O(h) recursive.

**Edge cases:** Key not present (tree unchanged), deleting the root, deleting the only node, a node with only a left or only a right child.

**Interview traps**
- **Reassign child links** from the recursive result (`root.left = delete(root.left, key)`). Forgetting it leaves the node in the tree.
- For the two-child case, delete the successor from the **right** subtree using its value.
- The "one child" case covers the leaf case if you check `left == null` first (returns `right`, which may be null).
- Mention you could relink nodes instead of copying values, if node identity matters.

**How to explain:** "I find the node. If it has at most one child I replace it by that child. If it has two, I copy in the smallest value from its right subtree, which keeps the order, and then delete that smallest node."
