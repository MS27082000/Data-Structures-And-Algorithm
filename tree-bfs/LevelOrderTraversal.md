# Level Order Traversal (LC 102)

**Problem:** Return the node values level by level (left to right), as a list of lists.

**Approach (BFS with a queue):** Enqueue the root. In each round, take a **snapshot of `queue.size()`**: that many nodes are exactly the current level. Poll each, record its value, and enqueue its children.

**Intuition:** A queue serves nodes in the order they were added, and children are added after all of their parent's level, so levels come out in order.

**Complexity:** Time O(n), Space O(w), where `w` is the maximum width (up to n/2 for a complete tree).

**Edge cases:** Empty tree (`[]`, not `[[]]`), a single node, a skewed tree (one node per level).

**Interview traps**
- **Fix the level size before the inner loop.** Using `queue.size()` in the loop condition changes it as you enqueue children.
- Return an empty list (not `null`) for an empty tree.
- Use `ArrayDeque`/`LinkedList` as the queue, not `Stack`.
- This is the template for **every** BFS-on-tree problem: zigzag, right view, width, bottom view, average of levels.

**How to explain:** "I run BFS with a queue. For each level I count the nodes currently in the queue, process exactly that many, and add their children for the next level."
