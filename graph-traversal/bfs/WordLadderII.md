# Word Ladder II (LC 126)

**Problem:** Same graph as [Word Ladder I](WordLadderI.md), but return **all** shortest transformation sequences.

**Brute force:** DFS/backtracking over all paths and keep the shortest → exponential.
**Optimal (BFS + parent links + DFS backtrack):**
1. **BFS by level** from `beginWord`, recording each word's distance. Whenever a neighbour `next` is at distance `dist[word] + 1`, add `word` to `parents[next]`. Stop the BFS after the level in which `endWord` is first found.
2. **DFS from `endWord`** back to `beginWord` along `parents`, building each path, then **reverse** it.
→ Only words on shortest paths are expanded.

**Intuition:** BFS finds the shortest length and which edges lie on *some* shortest path (the "shortest-path DAG"); a DFS over that DAG lists every path without exploring dead ends.

**Complexity:** Time roughly O(N · L · 26) for the BFS plus the output size (the number of shortest paths can be exponential), Space O(N · L).

**Edge cases:** `endWord` not in the list (empty), a single shortest path, several branches that merge, `beginWord` adjacent to `endWord`.

**Interview traps**
- **Do not stop BFS in the middle of a level.** Finish the level so every parent of `endWord` is recorded.
- Add a parent only when `dist[next] == dist[word] + 1` (same shortest-path layer).
- Build paths **from `endWord` backwards** (parents point towards `beginWord`) and reverse.
- A naive "store the full path in the BFS queue" approach runs out of memory/time on large inputs.

**How to explain:** "I BFS to get distances and record, for each word, which words reached it by a shortest step. Then I DFS from the end word back through those parent links to enumerate every shortest ladder."
