# Introduction to Graphs

## What a graph is
A graph `G = (V, E)` is a set of **vertices (nodes)** and **edges** connecting pairs of them. Trees, grids, social networks, maps and dependency lists are all graphs.

## Vocabulary
| Term | Meaning |
|---|---|
| **Undirected / Directed** | Edge `u–v` works both ways / only `u → v` |
| **Weighted** | Each edge has a cost |
| **Degree** | Number of edges at a node (directed: **in-degree** and **out-degree**) |
| **Path / Cycle** | A sequence of connected edges / a path that returns to its start |
| **Connected** | Every node can reach every other (undirected). Directed: *strongly* connected |
| **Component** | A maximal connected piece |
| **DAG** | Directed Acyclic Graph (topological order exists) |
| **Tree** | Connected, acyclic, `V − 1` edges |
| **Bipartite** | Nodes split into 2 sets with edges only between the sets (no odd cycle) |

## Representations
| | Adjacency **list** | Adjacency **matrix** |
|---|---|---|
| Space | **O(V + E)** | O(V²) |
| Edge `u–v` exists? | O(deg) | **O(1)** |
| Iterate neighbours | **O(deg)** | O(V) |
| Best for | Sparse graphs (most interview problems) | Dense graphs, Floyd-Warshall |

- **Undirected edge:** store it in **both** lists (`adj[u].add(v); adj[v].add(u)`).
- **Weighted:** neighbours as `{node, weight}`.
- **Edge list:** `{u, v, w}` triples. Handy for Kruskal and Bellman-Ford.
- **Implicit graphs:** a grid (neighbours = 4 directions), a word list (differ by one letter), game states. You never build the graph, you generate neighbours on the fly.

## Useful facts
- A simple undirected graph has at most `V(V−1)/2` edges. A directed one has `V(V−1)`.
- A sum of degrees = `2E` (undirected).
- Input node labels may be **1-indexed**. Check before sizing arrays.

## Complexity of the standard traversals
BFS / DFS: **O(V + E)** time with a list, O(V²) with a matrix.

## Interview traps
- Forgetting the **reverse edge** for undirected graphs.
- Assuming the graph is **connected**. Loop over all nodes.
- Choosing a matrix for a sparse graph (memory blow-up for large V).
- Self-loops and parallel edges: ask whether they exist.

**How to explain:** "I'd store the graph as an adjacency list since it's sparse: each node keeps its neighbours, so traversals take O(V + E). For an undirected graph I add each edge in both directions."
