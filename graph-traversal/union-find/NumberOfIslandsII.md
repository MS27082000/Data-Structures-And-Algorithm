# Number of Islands II (LC 305)

**Problem:** An `m × n` grid starts as all water. Land is added **one cell at a time** (`positions[i] = {r, c}`). After **each** addition, report the number of islands (4-directional connectivity).

**Brute force:** Recount islands with DFS after every addition → O(K · m · n).
**Optimal (online Union-Find):** Keep a DSU over the cells and a running `count`:
1. Adding a new land cell: `count++`.
2. For each of its 4 neighbours that is **already land**, `union` them. **Every union of two different components merges two islands: `count--`.**
3. Append `count` to the answer.
→ **O(K · α(m·n))** time.

**Intuition:** DSU supports exactly the operation we need, merging groups, and answers "how many groups" in O(1). Static DFS can't handle online updates efficiently.

**Complexity:** Time O(K · α), Space O(m · n).

**Edge cases:** A **repeated position** (already land: nothing changes, repeat the previous count), a cell that merges 2, 3 or 4 islands at once, diagonal neighbours (**not** connected), a 1×1 grid.

**Interview traps**
- Mark the cell as land **before** looking at neighbours, and **skip duplicates**.
- Decrement the count **only when a union actually merges different roots**.
- Use `-1` (or a separate `isLand`) to distinguish water from land in the DSU array.
- Flattened index: `r * n + c`.

**How to explain:** "I keep a union-find over the cells and a count of islands. Each new land cell adds one island, then every union with a neighbouring land cell that joins two different groups removes one. So each update takes almost constant time."
