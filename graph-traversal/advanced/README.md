# Advanced Graph Algorithms

Source: Striver's A2Z DSA Sheet, Graphs → Additional Algorithms (3 items). Active recall: open the link, solve from scratch, then check the notes.

## What they are for
| Algorithm | Finds | Graph |
|---|---|---|
| **Kosaraju / Tarjan** | Strongly connected components | Directed |
| **Bridges** | Edges whose removal disconnects the graph | Undirected |
| **Articulation points** | Nodes whose removal disconnects the graph | Undirected |

## Tarjan's low-link idea (bridges and cut vertices)
`tin[u]` = discovery time · `low[u]` = earliest `tin` reachable from `u`'s subtree via tree edges + one back edge.
- **Bridge** `u–v` (tree edge): `low[v] > tin[u]`
- **Articulation point** `u` (non-root): some child `v` has `low[v] >= tin[u]`; the **root** needs `> 1` DFS child.

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Kosaraju's Algorithm](KosarajuSCC.md) | [GfG](https://www.geeksforgeeks.org/problems/strongly-connected-components-kosarajus-algo/1) | DFS finish order, transpose, DFS | O(V + E) |
| 2 | [Bridges in a Graph](BridgesInGraph.md) | [LC 1192](https://leetcode.com/problems/critical-connections-in-a-network/) | `low[v] > tin[u]` | O(V + E) |
| 3 | [Articulation Points](ArticulationPoints.md) | [GfG](https://www.geeksforgeeks.org/problems/articulation-point-1/1) | `low[v] >= tin[u]`, root rule | O(V + E) |

## Run any program
```
javac -d out *.java
java -cp out BridgesInGraph
```
