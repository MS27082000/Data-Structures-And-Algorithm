# Graphs

Source: Striver's A2Z DSA Sheet, Graphs (46 items). They are organised by technique:

| Folder | Topics | Items |
|---|---|---|
| [graph-basics](graph-basics/README.md) | Introduction, BFS/DFS traversal, connected components | 3 |
| [dfs](dfs/README.md) | Provinces, islands, flood fill, enclaves, surrounded regions, distinct islands, cycle detection (both kinds), bipartite | 9 |
| [bfs](bfs/README.md) | Rotten oranges, nearest 1, unit-weight shortest path, Word Ladder I & II | 5 |
| [topological-sort](topological-sort/README.md) | Kahn's algorithm, Course Schedule I & II, Alien Dictionary, Eventual Safe States, DAG shortest path | 6 |
| [shortest-path](shortest-path/README.md) | Dijkstra and its variations, Bellman-Ford, Floyd-Warshall | 12 |
| [minimum-spanning-tree](minimum-spanning-tree/README.md) | MST theory + Prim, Kruskal | 2 (+ Disjoint Set) |
| [union-find](union-find/README.md) | Disjoint Set and the problems it solves | 6 |
| [advanced](advanced/README.md) | Kosaraju, bridges, articulation points | 3 |

## Choosing the right tool
| Question | Technique |
|---|---|
| Are things connected / how many groups? | DFS/BFS, or Union-Find if edges arrive over time |
| Fewest steps, equal costs | BFS (multi-source if many starts) |
| Shortest path, weights ≥ 0 | Dijkstra |
| Negative weights / at most K edges | Bellman-Ford |
| All pairs | Floyd-Warshall |
| Ordering with dependencies / cycle in a directed graph | Topological sort (Kahn) |
| Cycle in an undirected graph | DFS with parent, or Union-Find |
| 2-colouring / odd cycle | BFS/DFS colouring |
| Cheapest way to connect everything | MST (Prim / Kruskal) |
| Mutually reachable groups (directed) | SCC (Kosaraju / Tarjan) |
| Critical edges / nodes | Bridges / articulation points |

## Grids are graphs
A cell is a node and its 4 (or 8) neighbours are edges. The same DFS/BFS/Dijkstra templates apply, with `dirs = {{1,0},{-1,0},{0,1},{0,-1}}` and bounds checks.

## Run any program
Each subfolder is independent: `cd` into it and run `javac -d out *.java` then `java -cp out ClassName`.
