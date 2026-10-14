# Grid DP

Source: Striver's A2Z DSA Sheet, Dynamic Programming. Pattern: a cell depends on neighbours above and to the left (or the three above). Active recall: open the link, solve from scratch, then check the notes.

| # | Question (notes) | Practice | Idea | Time |
|---|---|---|---|---|
| 1 | [Grid Unique Paths](GridUniquePaths.md) | [LC 62](https://leetcode.com/problems/unique-paths/) | up + left, or C(m+n-2, m-1) | O(m*n) |
| 2 | [Unique Paths II](UniquePathsII.md) | [LC 63](https://leetcode.com/problems/unique-paths-ii/) | Obstacle cell = 0 ways | O(m*n) |
| 3 | [Minimum Falling Path Sum](MinimumFallingPathSum.md) | [LC 931](https://leetcode.com/problems/minimum-falling-path-sum/) | Min of three parents above | O(n^2) |
| 4 | [Triangle](Triangle.md) | [LC 120](https://leetcode.com/problems/triangle/) | Bottom-up, min of two children | O(n^2) |
| 5 | [Cherry Pickup II](CherryPickupII.md) | [LC 1463](https://leetcode.com/problems/cherry-pickup-ii/) | State (row, col1, col2), 9 moves | O(r*c^2) |
| 6 | [Count Square Submatrices](CountSquareSubmatrices.md) | [LC 1277](https://leetcode.com/problems/count-square-submatrices-with-all-ones/) | 1 + min of 3 neighbours, sum all | O(m*n) |

## Run any program
```r
javac -d out *.java
java -cp out GridUniquePaths
```
