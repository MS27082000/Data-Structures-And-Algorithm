# Unbounded Knapsack

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Items can be reused; loop the capacity **upwards**. Coins in the outer loop = combinations; amount in the outer loop = permutations. Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Minimum Coins](MinimumCoins.md) | [LC 322](https://leetcode.com/problems/coin-change/) | 1 + min(dp[a - coin]) | O(A*n) |
| 2 | [Coin Change II](CoinChangeII.md) | [LC 518](https://leetcode.com/problems/coin-change-ii/) | Coins outer loop = combinations | O(A*n) |
| 3 | [Unbounded Knapsack](UnboundedKnapsack.md) | [GfG](https://www.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1) | Upward capacity loop | O(n*W) |
| 4 | [Rod Cutting](RodCutting.md) | [GfG](https://www.geeksforgeeks.org/problems/rod-cutting0840/1) | Piece length = weight | O(n^2) |

## Run any program
```r
javac -d out *.java
java -cp out CoinChangeII
```
