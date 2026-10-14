# Correct a BST with Two Nodes Swapped (Recover BST, LC 99)

**Problem:** Exactly **two nodes** of a BST had their values swapped by mistake. Recover the BST without changing its structure.

**Brute force:** Inorder into a list, sort it, then write the sorted values back in inorder order → O(n log n) time, O(n) space.
**Optimal (one inorder pass):** In a valid BST the inorder sequence is increasing. A swap creates **descents** (`prev > cur`):
- **Adjacent swap** (e.g. `1 3 2 4`) → **one** descent `(3, 2)`: the two nodes are `prev` and `cur` of that descent.
- **Non-adjacent swap** (e.g. `2 8 4 5 6 3 9`) → **two** descents `(8, 4)` and `(6, 3)`: `first = prev` of the **first** descent (8) and `second = cur` of the **last** descent (3).
Then **swap their values** → O(n) time, O(h) space.

**Intuition:** Moving a large value to an earlier position creates a drop at its new spot; moving a small value to a later position creates another drop. The bigger swapped value shows up as `prev` in the first drop; the smaller as `cur` in the last drop.

**Complexity:** Time O(n), Space O(h) (O(1) with Morris traversal).

**Edge cases:** Swapped parent/child, swapped nodes at the two ends, the root involved.

**Interview traps**
- **Don't stop at the first descent.** A non-adjacent swap has two. Keep updating `second` and set `first` only once.
- `first = prev` (the larger value), `second = cur` (the smaller value).
- Swap **values**, not node pointers (much simpler).
- Declare `prev`, `first`, `second` as shared fields across the recursion.

**How to explain:** "I do an inorder traversal and look for places where a value is smaller than the one before it. The first such spot gives one swapped node (the earlier, larger value), and the last such spot gives the other (the later, smaller value). I swap their values back."
