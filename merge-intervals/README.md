# Merge Intervals

Source: Striver's A2Z DSA Sheet, Greedy Algorithms → Scheduling and Interval Problems. These 5 are interval questions, so they live under this pattern. Active recall: open the link, solve from scratch, then check the notes.

## When to use
- Overlapping ranges, meeting rooms, scheduling, "merge", "insert", "remove the fewest"
- The first step is almost always: **sort the intervals** (by start to merge, by end to select)

## Cheat sheet
| Goal | Sort by | Rule |
|---|---|---|
| Merge overlapping | **start** | `next.start <= cur.end` → `cur.end = max(cur.end, next.end)` |
| Max non-overlapping set / min removals | **end** | Keep if `start >= lastEnd` |
| Max overlap at one time (rooms / platforms) | start and end **separately** | Sweep: arrival +1, departure −1 |
| Insert into a sorted list | already sorted | before / overlapping / after |

## Overlap test
Two intervals `[a, b]` and `[c, d]` overlap iff `a <= d && c <= b`. **Touching** (`b == c`) is overlap for **merging** but not for **selection** (`[1,2]`, `[2,3]` can both be kept). Always confirm the convention.

## Questions
| # | Question (notes) | Practice | Idea | Time | Space |
|---|---|---|---|---|---|
| 1 | [Merge Intervals](MergeIntervals.md) | [LC 56](https://leetcode.com/problems/merge-intervals/) | Sort by start, extend | O(n log n) | O(n) |
| 2 | [Insert Interval](InsertInterval.md) | [LC 57](https://leetcode.com/problems/insert-interval/) | Three phases | O(n) | O(n) |
| 3 | [Non-overlapping Intervals](NonOverlappingIntervals.md) | [LC 435](https://leetcode.com/problems/non-overlapping-intervals/) | Sort by end | O(n log n) | O(1) |
| 4 | [N Meetings in One Room](NMeetingsInOneRoom.md) | [GfG](https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1) | Sort by end | O(n log n) | O(n) |
| 5 | [Minimum Platforms](MinimumPlatforms.md) | [GfG](https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1) | Sorted sweep | O(n log n) | O(1) |

## Related
Other greedy problems: [greedy-algorithms](../greedy-algorithms/README.md).

## Run any program
```
javac -d out *.java
java -cp out MergeIntervals
```
