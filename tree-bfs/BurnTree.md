# Minimum Time to Burn the Binary Tree from a Given Node

**Problem:** Fire starts at a target node. Each minute it spreads to the node's **left child, right child and parent**. How many minutes until the whole tree is burnt?

**Approach:** This is "distance from the target to the **farthest** node".
1. Record parent pointers (to move upward).
2. **BFS from the target** with a visited set, one level = one minute.
3. Count the levels in which the fire reached **new** nodes. The answer is the number of such levels → O(n), O(n).

**Intuition:** Fire spreads exactly like BFS on the undirected tree-graph; the time to burn everything is the eccentricity of the start node (its distance to the farthest node).

**Complexity:** Time O(n), Space O(n).

**Edge cases:** A single node (0 minutes), the target is the root, the target is a leaf (the farthest node may be on the other side of the tree), skewed trees.

**Interview traps**
- Increment `minutes` **only when new nodes caught fire** in that round. Otherwise you count one extra level at the end.
- Same machinery as **Nodes at Distance K**: parent map + BFS + visited. Say so in the interview.
- A one-pass recursive solution exists (return the height and the distance to the target), but the BFS version is easier to get right.

**How to explain:** "I treat the tree as an undirected graph by storing parents, then BFS outward from the burning node. Each BFS level is one minute, and the number of levels needed to reach every node is the answer."
