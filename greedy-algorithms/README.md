# Greedy Algorithms

Source: Striver's A2Z DSA Sheet, Greedy Algorithms (14 items). The 9 pure greedy problems are here; the 5 interval problems are in [merge-intervals](../merge-intervals/README.md).
Active recall: open the link, solve from scratch, then check the notes.

## What greedy means
At every step take the choice that looks best **right now** and never reconsider. It works only when the problem has the **greedy-choice property** (a locally best choice is part of some global optimum) and **optimal substructure**.

## How to recognise and prove it
- Keywords: "minimum number of…", "maximum number of…", scheduling, intervals, "earliest/smallest/largest first".
- Typical first move: **sort** by the right key (end time, ratio, profit, deadline).
- Justify with an **exchange argument**: swapping any optimal solution's choice for the greedy choice never makes it worse.
- If greedy fails on a small counter-example, the problem likely needs **DP** (e.g. 0/1 Knapsack, Coin Change with odd denominations).

## Easy
| Question (notes) | Practice | Greedy rule | Time |
|---|---|---|---|
| [Assign Cookies](AssignCookies.md) | [LC 455](https://leetcode.com/problems/assign-cookies/) | Smallest sufficient cookie | O(n log n) |
| [Lemonade Change](LemonadeChange.md) | [LC 860](https://leetcode.com/problems/lemonade-change/) | Give 10 + 5 before 5 + 5 + 5 | O(n) |
| [Fractional Knapsack](FractionalKnapsack.md) | [GfG](https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1) | Best value / weight first | O(n log n) |
| [Jump Game I](JumpGameI.md) | [LC 55](https://leetcode.com/problems/jump-game/) | Track farthest reach | O(n) |

## Scheduling and Interval Problems
| Question (notes) | Practice | Greedy rule | Time |
|---|---|---|---|
| [Shortest Job First](ShortestJobFirst.md) | [GfG](https://www.geeksforgeeks.org/problems/shortest-job-first/1) | Shortest burst first | O(n log n) |
| [Job Sequencing Problem](JobSequencing.md) | [GfG](https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1) | Highest profit, latest free slot | O(n log n + nD) |
| [N Meetings in One Room](../merge-intervals/NMeetingsInOneRoom.md) | [GfG](https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1) | Earliest end first | O(n log n) |
| [Non-overlapping Intervals](../merge-intervals/NonOverlappingIntervals.md) | [LC 435](https://leetcode.com/problems/non-overlapping-intervals/) | Earliest end first | O(n log n) |
| [Insert Interval](../merge-intervals/InsertInterval.md) | [LC 57](https://leetcode.com/problems/insert-interval/) | Before / overlap / after | O(n) |
| [Merge Intervals](../merge-intervals/MergeIntervals.md) | [LC 56](https://leetcode.com/problems/merge-intervals/) | Sort by start, extend end | O(n log n) |
| [Minimum Platforms](../merge-intervals/MinimumPlatforms.md) | [GfG](https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1) | Sweep sorted arrivals/departures | O(n log n) |

## Hard
| Question (notes) | Practice | Greedy rule | Time |
|---|---|---|---|
| [Valid Parenthesis Checker (with `*`)](ValidParenthesisChecker.md) | [LC 678](https://leetcode.com/problems/valid-parenthesis-string/) | Track range [lo, hi] of open count | O(n) |
| [Candy](Candy.md) | [LC 135](https://leetcode.com/problems/candy/) | Two passes, take max | O(n) |
| [Jump Game II](JumpGameII.md) | [LC 45](https://leetcode.com/problems/jump-game-ii/) | Implicit BFS levels | O(n) |

## Run any program
```
javac -d out *.java
java -cp out Candy
```
