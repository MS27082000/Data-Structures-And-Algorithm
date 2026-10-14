# 0/1 Knapsack

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Each item is used at most once; in 1D loop the capacity **downwards**. Reusable-item versions are in [unbounded-knapsack](../unbounded-knapsack/README.md). Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Subset Sum Equals to Target](SubsetSumEqualsTarget.md) | [GfG](https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1) | Reachable sums, downward loop | O(n*T) |
| 2 | [Partition Equal Subset Sum](PartitionEqualSubsetSum.md) | [LC 416](https://leetcode.com/problems/partition-equal-subset-sum/) | Even total, subset sum total/2 | O(n*S) |
| 3 | [Minimum Subset Sum Difference](MinimumSubsetSumDifference.md) | [GfG](https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1) | total - 2s for reachable s <= total/2 | O(n*S) |
| 4 | [Count Subsets with Sum K](CountSubsetsWithSumK.md) | [GfG](https://www.geeksforgeeks.org/problems/perfect-sum-problem5633/1) | Count ways; zeros double | O(n*K) |
| 5 | [Count Partitions with Given Difference](CountPartitionsWithGivenDifference.md) | [GfG](https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1) | S1 = (total + d) / 2 | O(n*T) |
| 6 | [0/1 Knapsack](ZeroOneKnapsack.md) | [GfG](https://www.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1) | Take or skip | O(n*W) |
| 7 | [Target Sum](TargetSum.md) | [LC 494](https://leetcode.com/problems/target-sum/) | P = (total + target) / 2 | O(n*P) |

## Run any program
```r
javac -d out *.java
java -cp out ZeroOneKnapsack
```
