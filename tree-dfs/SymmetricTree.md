# Check for Symmetrical Binary Trees (LC 101)

**Problem:** Is the tree a **mirror image of itself** around the centre?

**Approach (recursive):** A tree is symmetric if its left and right subtrees are **mirrors** of each other. `isMirror(a, b)`:
- both `null` → true; one `null` → false
- `a.val == b.val` **and** `isMirror(a.left, b.right)` **and** `isMirror(a.right, b.left)`.
The pairing is **outer with outer, inner with inner**.

**Iterative:** A queue of node **pairs** that must match. Enqueue `(a.left, b.right)` and `(a.right, b.left)`. Use a queue that accepts `null` (e.g. `LinkedList`; `ArrayDeque` throws on null).

**Intuition:** Reflect the right subtree and compare it with the left one. Doing both at once avoids building a mirrored copy.

**Complexity:** Time O(n), Space O(h) recursive / O(w) iterative.

**Edge cases:** Empty tree (symmetric), a single node, same values but the wrong shape (`[1,2,2,null,3,null,3]` is **not** symmetric).

**Interview traps**
- It's **not** "left subtree equals right subtree" ([Same Tree](IdenticalTrees.md)); it's left equals the **mirror** of right.
- Compare `a.left` with `b.right` (crossed), not `a.left` with `b.left`.
- `ArrayDeque` can't hold `null`; use `LinkedList` if you enqueue null children.

**How to explain:** "I compare the left subtree with the right subtree as mirrors: the outer children must match and the inner children must match, checked recursively."
