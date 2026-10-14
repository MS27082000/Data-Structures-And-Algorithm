# Maximum XOR With an Element From Array (LC 1707)

**Problem:** For each query `(x, m)`, find the maximum `x ^ nums[j]` among `nums[j] <= m`, or -1 if none.

**Intuition:** Same XOR trie, but each query only allows numbers `<= m`. Solve **offline**: sort nums, sort the queries by `m`, and sweep. Before answering a query insert all numbers `<= m` into the trie. Store answers by the original query index.

**Brute force:** For each query scan all allowed numbers, O(q * n).
**Optimised:** O((n + q) * 31 + n log n + q log q).

**Edge cases:** No number `<= m` -> -1. Duplicate numbers. Queries in any order (restore with the index).

**Interview traps**
- Offline sorting is the trick; an online trie would need extra "minimum value per node" tracking (a valid alternative).
- Return -1 when nothing has been inserted yet.
- Keep the answer array indexed by the original query position.

**How to explain:** "I answer queries in increasing order of the limit, growing the trie as the limit grows, so every query sees exactly the allowed numbers."
