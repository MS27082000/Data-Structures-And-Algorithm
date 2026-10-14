# Union-Find (Disjoint Set Union)

Source: Striver's A2Z DSA Sheet, Graphs → Minimum Spanning Tree (Disjoint Set) and Hard Problems II. Active recall: open the link, solve from scratch, then check the notes.

## When to use
- "Are these two connected?" with **merging over time** (online)
- Counting **components** that change as edges or cells are added
- **Cycle detection** in an undirected graph (union of two nodes already together = cycle)
- **Kruskal's MST**, equivalence classes, merging accounts/groups

## Template
```java
int find(int x) { while (parent[x] != x) { parent[x] = parent[parent[x]]; x = parent[x]; } return x; }   // path compression
boolean union(int a, int b) {
    int ra = find(a), rb = find(b);
    if (ra == rb) return false;                                   // already together
    if (size[ra] < size[rb]) { int t = ra; ra = rb; rb = t; }     // union by size
    parent[rb] = ra; size[ra] += size[rb]; return true;
}
```
Each operation is **O(α(n))** (practically constant). DSU only **merges**; it can't split.

## Questions
| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Disjoint Set](DisjointSet.md) | [GfG](https://www.geeksforgeeks.org/problems/disjoint-set-union-find/1) | Parent array, compression, union by size | O(α) |
| 2 | [Number of Operations to Make Network Connected](NumberOfOperationsToMakeNetworkConnected.md) | [LC 1319](https://leetcode.com/problems/number-of-operations-to-make-network-connected/) | `components − 1` if enough cables | O(n + E α) |
| 3 | [Accounts Merge](AccountsMerge.md) | [LC 721](https://leetcode.com/problems/accounts-merge/) | Union accounts sharing an email | O(NK log NK) |
| 4 | [Number of Islands II](NumberOfIslandsII.md) | [LC 305](https://leetcode.com/problems/number-of-islands-ii/) (premium) | Online unions, running count | O(K α) |
| 5 | [Making A Large Island](MakingALargeIsland.md) | [LC 827](https://leetcode.com/problems/making-a-large-island/) | Island sizes + best water flip | O(n² α) |
| 6 | [Most Stones Removed](MostStonesRemoved.md) | [LC 947](https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/) | Rows and columns as nodes | O(S α) |

(Kruskal's MST, which uses this structure: [MSTWeight](../minimum-spanning-tree/MSTWeight.md).)

## Run any program
```
javac -d out *.java
java -cp out DisjointSet
```
