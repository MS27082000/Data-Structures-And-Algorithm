# Longest Common Subsequence (LCS) family

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Pattern: a 2D table over prefixes of two strings. Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Longest Common Subsequence](LongestCommonSubsequence.md) | [LC 1143](https://leetcode.com/problems/longest-common-subsequence/) | Match: 1 + diagonal, else max | O(m*n) |
| 2 | [Longest Common Substring](LongestCommonSubstring.md) | [GfG](https://www.geeksforgeeks.org/problems/longest-common-substring1452/1) | Reset to 0 on mismatch | O(m*n) |
| 3 | [Longest Palindromic Subsequence](LongestPalindromicSubsequence.md) | [LC 516](https://leetcode.com/problems/longest-palindromic-subsequence/) | LCS(s, reverse s) | O(n^2) |
| 4 | [Minimum Insertions to Make Palindrome](MinimumInsertionsToMakePalindrome.md) | [LC 1312](https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/) | n - LPS | O(n^2) |
| 5 | [Min Insertions and Deletions A to B](MinimumInsertionsDeletionsAToB.md) | [GfG](https://www.geeksforgeeks.org/problems/minimum-number-of-deletions-and-insertions0209/1) | m + n - 2*LCS | O(m*n) |
| 6 | [Shortest Common Supersequence](ShortestCommonSupersequence.md) | [LC 1092](https://leetcode.com/problems/shortest-common-supersequence/) | Walk the LCS table back | O(m*n) |
| 7 | [Distinct Subsequences](DistinctSubsequences.md) | [LC 115](https://leetcode.com/problems/distinct-subsequences/) | Use it or skip it | O(m*n) |

## Run any program
```r
javac -d out *.java
java -cp out LongestCommonSubsequence
```
