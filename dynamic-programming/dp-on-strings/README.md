# DP on Strings

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Other string DPs (LCS, palindromes, distinct subsequences) live in [longest-common-subsequence](../longest-common-subsequence/README.md). Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Edit Distance](EditDistance.md) | [LC 72](https://leetcode.com/problems/edit-distance/) | min of insert, delete, replace | O(m*n) |
| 2 | [Wildcard Matching](WildcardMatching.md) | [LC 44](https://leetcode.com/problems/wildcard-matching/) | * = empty or eats one char | O(m*n) |
| 3 | [Word Break](WordBreak.md) | [LC 139](https://leetcode.com/problems/word-break/) | Breakable prefix plus a word | O(n*L^2) |
| 4 | [Count Palindromic Subsequences](CountPalindromicSubsequences.md) | [GfG](https://www.geeksforgeeks.org/problems/count-palindromic-subsequences/1) | Inclusion-exclusion on ranges | O(n^2) |

> Assumption: the sheet's Count Palindromic Subsequences is implemented as the GfG problem that counts by position.

## Run any program
```r
javac -d out *.java
java -cp out EditDistance
```
