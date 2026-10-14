# Serialize and Deserialize a Binary Tree (LC 297)

**Problem:** Convert a binary tree into a string (**serialize**) and rebuild the same tree from that string (**deserialize**). Any format is allowed as long as it round-trips.

**Approach (preorder with null markers):**
- **Serialize:** preorder DFS. Write the value for a node, or `#` for `null`, each followed by a comma.
- **Deserialize:** split by commas and consume tokens **in the same order**: the next token is the root; then recursively build the **entire left subtree**, then the **entire right subtree**. `#` returns `null`.

**Why the `#` markers are essential:** Preorder alone is ambiguous (many trees share it). With explicit nulls, the string pins down the exact shape.

**Alternative:** **Level-order (BFS)** with null markers, which is the format LeetCode displays (`[1,2,3,null,null,4,5]`). Needs a queue for both directions.

**Complexity:** Time O(n), Space O(n) (string and recursion).

**Edge cases:** Empty tree, a single node, negative numbers and zero, a skewed tree, multi-digit values (the comma separator is why we can tell `12` from `1,2`).

**Interview traps**
- You **need a delimiter** (comma) between values and a **null marker**.
- Deserialization must read tokens with a **shared pointer/queue** (an index or a `Deque`), not re-split per call.
- **Avoid** `String +=` in recursion for big trees; use `StringBuilder`.
- Deep trees can overflow the stack. Mention the BFS version.

**How to explain:** "I write the tree in preorder and mark every missing child with `#`. To rebuild, I read the tokens in the same order: take a value as the root, then recursively build its left subtree, then its right subtree."
