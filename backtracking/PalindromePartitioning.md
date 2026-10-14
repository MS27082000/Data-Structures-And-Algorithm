# Palindrome Partitioning (LC 131)

**Problem:** Partition a string so that **every substring is a palindrome**. Return all such partitions.

**Brute force:** Generate all `2^(n-1)` ways to cut, then check each piece → wasteful.
**Optimal:** **Backtracking.** From `start`, try every `end`; if `s[start..end]` is a palindrome, add it and recurse from `end + 1`. When `start == n`, record the partition.

**Intuition:** We only extend a partition with palindromic pieces, so invalid partitions are pruned immediately.

**Optimisation:** Precompute `isPal[i][j]` with DP (O(n²)) so each check is O(1). Then total work is dominated by the output.

**Complexity:** Time O(n · 2ⁿ) worst case (e.g. `"aaaa"`), Space O(n) stack.

**Edge cases:** Single character, all identical characters (maximum partitions), no multi-character palindromes (only singles).

**Interview traps**
- Every single character is a palindrome, so a valid partition always exists.
- Record a **copy** of the path.
- Undo the add (`remove(size - 1)`) after recursing.
- Mention the DP precompute for the palindrome check if asked to optimise. **Palindrome Partitioning II** (min cuts) is the DP follow-up.

**How to explain:** "At each position I try every possible end for the next piece. If the piece is a palindrome I take it and recurse on the rest; reaching the end of the string records a full partition."
