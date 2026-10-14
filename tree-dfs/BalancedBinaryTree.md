# Check for Balanced Binary Tree (LC 110)

**Problem:** A tree is **height-balanced** if, for **every node**, the heights of its left and right subtrees differ by at most 1.

**Brute force:** At each node compute the heights of both subtrees with a separate `height()` call and compare → **O(n²)** for skewed trees (heights are recomputed).
**Optimal (one bottom-up pass):** A recursive `checkHeight(node)` returns the **height**, or **−1** if the subtree is unbalanced. If either child returns −1, or `|left − right| > 1`, return −1; otherwise return `1 + max(left, right)` → **O(n)**.

**Intuition:** Compute height and check balance in the same postorder pass. The sentinel −1 carries the "unbalanced" signal upward so the answer is known without extra work.

**Complexity:** Time O(n), Space O(h).

**Edge cases:** Empty tree (balanced), a single node, a skewed tree of 3+ nodes (not balanced), a tree whose root looks balanced but a lower node isn't.

**Interview traps**
- Check **every** node, not just the root.
- Return **early** when a child is −1 (avoids needless work).
- Don't use a global boolean *and* call `height` repeatedly (that's the O(n²) trap).
- Same pattern for Diameter and Max Path Sum: compute something at each node while returning the height.

**How to explain:** "I compute heights bottom-up. If a subtree is unbalanced I return −1, which propagates to the root; otherwise I return the usual height. So I get the answer in a single O(n) pass."
