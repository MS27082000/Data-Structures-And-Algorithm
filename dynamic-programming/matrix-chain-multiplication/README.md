# Matrix Chain Multiplication (interval DP) family

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Pattern: try every split point of a range and combine the two sub-ranges. Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Matrix Chain Multiplication](MatrixChainMultiplication.md) | [GfG](https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1) | Try every split k | O(n^3) |
| 2 | [Burst Balloons](BurstBalloons.md) | [LC 312](https://leetcode.com/problems/burst-balloons/) | Choose the LAST balloon | O(n^3) |
| 3 | [Palindrome Partitioning II](PalindromePartitioningII.md) | [LC 132](https://leetcode.com/problems/palindrome-partitioning-ii/) | Palindrome table + prefix cuts | O(n^2) |
| 4 | [Partition Array for Maximum Sum](PartitionArrayForMaximumSum.md) | [LC 1043](https://leetcode.com/problems/partition-array-for-maximum-sum/) | Last block length up to k | O(n*k) |
| 5 | [Minimum Cost to Cut a Stick](MinimumCostToCutStick.md) | [LC 1547](https://leetcode.com/problems/minimum-cost-to-cut-a-stick/) | Choose the FIRST cut | O(m^3) |
| 6 | [Boolean Expression Ways](BooleanExpressionWays.md) | [GfG](https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1) | Combine true/false counts per operator | O(n^3) |

> Assumption: the sheet's Boolean Expression item is implemented as GfG's Boolean Parenthesization.

## Run any program
```r
javac -d out *.java
java -cp out MatrixChainMultiplication
```
