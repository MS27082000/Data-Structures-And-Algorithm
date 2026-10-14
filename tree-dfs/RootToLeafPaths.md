# Print Root to Leaf Paths in a Binary Tree (LC 257)

**Problem:** List every path from the root to a leaf (e.g. `1->2->5`).

**Approach (DFS + backtracking):** Keep a `path` list. At each node **add** it. If it's a **leaf**, record a **copy** of the path. Otherwise recurse into the children. On the way back, **remove** the node (backtrack) → O(n·h) time, O(h) stack.

**String variant:** Pass the path as an immutable `String` (`prefix + "->" + val`). Each call has its own string, so no explicit backtracking is needed.

**Intuition:** A path is the root-to-node chain of ancestors; DFS with push/pop maintains exactly that chain.

**Complexity:** Time O(n·h) (copying each path costs up to h; there are as many paths as leaves), Space O(h) plus the output.

**Edge cases:** Empty tree (no paths), a single node (one path), a node with only one child (it is **not** a leaf).

**Interview traps**
- **Copy the list** when recording (`new ArrayList<>(path)`). Otherwise all stored paths end up empty after backtracking.
- A **leaf** has **both** children null. Recording at `null` instead of at the leaf gives duplicates.
- Don't forget the **backtrack** step with the list version.
- Variants built on the same skeleton: **Path Sum I/II**, **Sum Root to Leaf Numbers**, longest path.

**How to explain:** "I DFS from the root keeping the current path. At a leaf I save a copy of it, and when I return from a node I remove it from the path so the other branches start clean."
