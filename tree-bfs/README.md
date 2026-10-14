# Tree BFS (Level Order)

Source: Striver's A2Z DSA Sheet, Binary Trees (32 items). The level-order family is here (9 items). The recursive / DFS family is in [tree-dfs](../tree-dfs/README.md). Active recall: open the link, solve from scratch, then check the notes.

## When to use
Level-by-level processing, "view" problems (top, bottom, left, right), widths, shortest distances in a tree, anything with a "level" or "minutes/steps".

## Template
```java
Queue<TreeNode> queue = new ArrayDeque<>();
queue.offer(root);
while (!queue.isEmpty()) {
    int size = queue.size();                // SNAPSHOT = the current level
    for (int i = 0; i < size; i++) {
        TreeNode node = queue.poll();
        // process node
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
    }
    // end of a level
}
```
Complexity of the template: Time O(n), Space O(w) (maximum width).

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Level Order Traversal](LevelOrderTraversal.md) | [LC 102](https://leetcode.com/problems/binary-tree-level-order-traversal/) | Queue + level snapshot | O(n) |
| 2 | [Zig Zag / Spiral Traversal](ZigZagTraversal.md) | [LC 103](https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/) | Alternate the fill direction | O(n) |
| 3 | [Vertical Order Traversal](VerticalOrderTraversal.md) | [LC 987](https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/) | (col, row, value) sort | O(n log n) |
| 4 | [Top View](TopView.md) | [GfG](https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1) | First node per column | O(n log n) |
| 5 | [Bottom View](BottomView.md) | [GfG](https://www.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1) | Last node per column | O(n log n) |
| 6 | [Right / Left View](LeftRightView.md) | [LC 199](https://leetcode.com/problems/binary-tree-right-side-view/) | Last / first of each level | O(n) |
| 7 | [Maximum Width of Binary Tree](MaximumWidth.md) | [LC 662](https://leetcode.com/problems/maximum-width-of-binary-tree/) | Heap indices, normalised | O(n) |
| 8 | [Nodes at Distance K](NodesAtDistanceK.md) | [LC 863](https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/) | Parent map + BFS | O(n) |
| 9 | [Minimum Time to Burn the Tree](BurnTree.md) | [GfG](https://www.geeksforgeeks.org/problems/burning-tree/1) | Parent map + BFS levels | O(n) |

## Run any program
```
javac -d out *.java
java -cp out LevelOrderTraversal
```
