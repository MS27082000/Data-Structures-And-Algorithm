# Minimum Insertions and Deletions to Convert A to B

**Problem:** Fewest insert/delete operations to turn string A into string B.

**Intuition:** Keep their LCS. Delete every other char of A (`m - lcs`) and insert every other char of B (`n - lcs`). Total = `m + n - 2*lcs`.

**Brute force:** BFS over edit operations.
**Optimised:** O(m*n) time, O(n) space.

**Edge cases:** Identical -> 0. No common chars -> m + n. Empty A or B.

**Interview traps**
- Only insert and delete are allowed here (Edit Distance also has replace).
- Delete Operation for Two Strings (LC 583) is the same formula.

**How to explain:** "The common subsequence stays; everything else in A is deleted and everything else in B is inserted."
