# Minimum Spanning Tree

Source: Striver's A2Z DSA Sheet, Graphs → Minimum Spanning Tree (3 items: MST theory, Disjoint Set, MST weight). The Disjoint Set is in [union-find](../union-find/README.md). Active recall: open the link, solve from scratch, then check the notes.

## Quick facts
- Spanning tree: all `V` nodes, `V − 1` edges, no cycle. **MST** = the one with minimum total weight.
- **Prim** (grow one tree, min-heap) · **Kruskal** (sort edges + Disjoint Set).
- Both are greedy and correct because of the **cut property** and **cycle property**.

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [MST Theory + Prim's Algorithm](PrimsAlgorithm.md) | [GfG](https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1) | Cheapest edge leaving the tree | O(E log V) |
| 2 | [Disjoint Set](../union-find/DisjointSet.md) | [GfG](https://www.geeksforgeeks.org/problems/disjoint-set-union-find/1) | Union by size + path compression | O(α(n)) |
| 3 | [Find the MST Weight (Kruskal)](MSTWeight.md) | [GfG](https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1) | Sort edges, skip cycle edges | O(E log E) |

## Run any program
```
javac -d out *.java
java -cp out MSTWeight
```
