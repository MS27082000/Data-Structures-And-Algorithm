# 1D DP

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Pattern: f(i) depends on the previous one, two or k values. Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Climbing Stairs](ClimbingStairs.md) | [LC 70](https://leetcode.com/problems/climbing-stairs/) | Fibonacci: from i-1 or i-2 | O(n) |
| 2 | [Frog Jump](FrogJump.md) | [Striver](https://takeuforward.org/data-structure/dynamic-programming-frog-jump-dp-3/) | Min of two previous stairs plus cost | O(n) |
| 3 | [Frog Jump with K Distances](FrogJumpWithKDistances.md) | [Striver](https://takeuforward.org/data-structure/dynamic-programming-frog-jump-with-k-distances-dp-4/) | Loop over k previous stairs | O(n*k) |
| 4 | [Maximum Sum of Non-Adjacent Elements](MaximumSumOfNonAdjacentElements.md) | [Striver](https://takeuforward.org/data-structure/maximum-sum-of-non-adjacent-elements-dp-5/) | Take (a[i] + f(i-2)) or skip | O(n) |
| 5 | [House Robber I and II](HouseRobber.md) | [LC 198 / 213](https://leetcode.com/problems/house-robber/) | Linear DP; circular = two ranges | O(n) |

## Run any program
```r
javac -d out *.java
java -cp out HouseRobber
```
