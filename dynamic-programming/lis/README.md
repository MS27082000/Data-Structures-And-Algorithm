# Longest Increasing Subsequence (LIS) family

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Pattern: dp[i] = best chain ending at i, built from earlier j that satisfy a relation. Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Longest Increasing Subsequence](LongestIncreasingSubsequence.md) | [LC 300](https://leetcode.com/problems/longest-increasing-subsequence/) | O(n^2) dp or tails + binary search | O(n log n) |
| 2 | [Print LIS](PrintLIS.md) | [GfG](https://www.geeksforgeeks.org/problems/printing-longest-increasing-subsequence/1) | Parent pointers | O(n^2) |
| 3 | [Largest Divisible Subset](LargestDivisibleSubset.md) | [LC 368](https://leetcode.com/problems/largest-divisible-subset/) | Sort, then LIS with divisibility | O(n^2) |
| 4 | [Longest String Chain](LongestStringChain.md) | [LC 1048](https://leetcode.com/problems/longest-string-chain/) | Sort by length, delete one char | O(n*L^2) |
| 5 | [Longest Bitonic Subsequence](LongestBitonicSubsequence.md) | [GfG](https://www.geeksforgeeks.org/problems/longest-bitonic-subsequence0824/1) | inc[i] + dec[i] - 1 | O(n^2) |
| 6 | [Number of LIS](NumberOfLIS.md) | [LC 673](https://leetcode.com/problems/number-of-longest-increasing-subsequence/) | len[] and cnt[] | O(n^2) |

## Run any program
```r
javac -d out *.java
java -cp out LongestIncreasingSubsequence
```
