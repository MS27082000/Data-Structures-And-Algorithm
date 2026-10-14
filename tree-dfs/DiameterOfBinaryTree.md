# Diameter of a Binary Tree (LC 543)

**Problem:** The **diameter** is the length (in **edges**) of the longest path between any two nodes. The path may or may not pass through the root.

**Brute force:** For each node compute `height(left) + height(right)` with separate height calls → O(n²) on skewed trees.
**Optimal:** Compute heights **bottom-up** and, at every node, update a global best with `leftHeight + rightHeight` (the longest path that bends at this node). Return `1 + max(left, right)` to the parent → **O(n)**.

**Intuition:** Every path has a highest node (where it turns). The longest path through that node goes down the deepest left branch and the deepest right branch, so its length is the sum of the two heights.

**Complexity:** Time O(n), Space O(h).

**Edge cases:** Empty tree (0), a single node (0), a skewed tree (n − 1), the longest path not through the root.

**Interview traps**
- **Edges vs nodes.** With heights measured in nodes, `left + right` already equals the number of edges.
- **Don't assume the path goes through the root.** Take the max over all nodes.
- Keep the answer in a field/array (a global) and **return the height** from the recursion. Two different quantities.
- Same skeleton as Maximum Path Sum and Balanced Tree.

**How to explain:** "For each node the longest path that turns there is the left height plus the right height. I compute heights bottom-up, record the best such sum, and return the height to the parent."
