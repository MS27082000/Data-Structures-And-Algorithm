# Binary Search

Source: Striver's A2Z DSA Sheet, Binary Search section (32 items). Active recall: open the link, solve from scratch, then check the notes.

## When to use
- Sorted or monotonic data, and an O(log n) requirement
- "Minimise the maximum" or "maximise the minimum" → **binary search on the answer**
- Any yes/no condition that flips only once (`false … false true … true`)

## Two templates to memorise
```java
// 1) First index where cond(i) is true (lower bound style). high = n is allowed.
int low = 0, high = n;
while (low < high) {
    int mid = low + (high - low) / 2;
    if (cond(mid)) high = mid; else low = mid + 1;
}
return low;

// 2) Classic exact search
int low = 0, high = n - 1;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (a[mid] == target) return mid;
    if (a[mid] < target) low = mid + 1; else high = mid - 1;
}
```

**Binary search on the answer:** pick the search range (min possible, max possible), write `isFeasible(x)`, and find the first (or last) feasible x.

## Fundamentals
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Search X in Sorted Array](BinarySearchBasic.md) | [LC 704](https://leetcode.com/problems/binary-search/) | Classic | O(log n) |
| [Lower Bound](LowerBound.md) | [GfG](https://www.geeksforgeeks.org/problems/implement-lower-bound/1) | First index `>= x` | O(log n) |
| [Upper Bound](UpperBound.md) | [GfG](https://www.geeksforgeeks.org/problems/implement-upper-bound/1) | First index `> x` | O(log n) |

## Logic Building
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Search Insert Position](SearchInsertPosition.md) | [LC 35](https://leetcode.com/problems/search-insert-position/) | = Lower bound | O(log n) |
| [Floor and Ceil](FloorAndCeil.md) | [GfG](https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1) | Record candidates while narrowing | O(log n) |
| [First and Last Occurrence](FirstAndLastOccurrence.md) | [LC 34](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/) | Lower and upper bound | O(log n) |
| [Search in Rotated Sorted Array I](SearchRotatedSortedArrayI.md) | [LC 33](https://leetcode.com/problems/search-in-rotated-sorted-array/) | One half is always sorted | O(log n) |
| [Search in Rotated Sorted Array II](SearchRotatedSortedArrayII.md) | [LC 81](https://leetcode.com/problems/search-in-rotated-sorted-array-ii/) | Same + trim duplicates | O(log n), worst O(n) |
| [Find Minimum in Rotated Sorted Array](FindMinimumInRotatedSortedArray.md) | [LC 153](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/) | Compare mid with high | O(log n) |
| [Rotation Count](RotationCount.md) | [GfG](https://www.geeksforgeeks.org/problems/rotation4723/1) | Index of the minimum | O(log n) |
| [Single Element in Sorted Array](SingleElementInSortedArray.md) | [LC 540](https://leetcode.com/problems/single-element-in-a-sorted-array/) | Index parity | O(log n) |
| [Count Occurrences](CountOccurrences.md) | [GfG](https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1) | Upper − lower bound | O(log n) |

## On Answers (binary search on the answer)
| Question (notes) | Practice | Feasibility check | Time |
|---|---|---|---|
| [Square Root](SquareRoot.md) | [LC 69](https://leetcode.com/problems/sqrtx/) | `mid*mid <= x` | O(log x) |
| [Nth Root](NthRoot.md) | [GfG](https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1) | `mid^n` vs `m` | O(n log m) |
| [Smallest Divisor](SmallestDivisor.md) | [LC 1283](https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/) | Sum of ceilings `<= threshold` | O(n log max) |
| [Koko Eating Bananas](KokoEatingBananas.md) | [LC 875](https://leetcode.com/problems/koko-eating-bananas/) | Hours `<= h` | O(n log max) |
| [Min Days to Make M Bouquets](MinDaysToMakeBouquets.md) | [LC 1482](https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/) | Bouquets `>= m` | O(n log range) |
| [Capacity to Ship Packages](CapacityToShipPackages.md) | [LC 1011](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/) | Days `<= D` | O(n log sum) |
| [Kth Missing Positive Number](KthMissingPositiveNumber.md) | [LC 1539](https://leetcode.com/problems/kth-missing-positive-number/) | `a[i] - (i+1) >= k` | O(log n) |
| [Painter's Partition](PaintersPartition.md) | [GfG](https://www.geeksforgeeks.org/problems/the-painters-partition-problem1535/1) | Painters `<= k` | O(n log sum) |

## FAQs
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Aggressive Cows](AggressiveCows.md) | [GfG](https://www.geeksforgeeks.org/problems/aggressive-cows/1) | Maximise the minimum distance | O(n log range) |
| [Book Allocation](BookAllocation.md) | [GfG](https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1) | Minimise the maximum pages | O(n log sum) |
| [Find Peak Element](FindPeakElement.md) | [LC 162](https://leetcode.com/problems/find-peak-element/) | Follow the slope | O(log n) |
| [Median of Two Sorted Arrays](MedianOfTwoSortedArrays.md) | [LC 4](https://leetcode.com/problems/median-of-two-sorted-arrays/) | Partition the smaller array | O(log min(m,n)) |
| [Kth Element of Two Sorted Arrays](KthElementOfTwoSortedArrays.md) | [GfG](https://www.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1) | Partition with bounds on i | O(log min(m,n)) |
| [Minimise Max Distance to Gas Station](MinimizeMaxDistanceGasStation.md) | [LC 774](https://leetcode.com/problems/minimize-max-distance-to-gas-station/) (premium) | Real-valued search | O(n log(range/ε)) |
| [Split Array Largest Sum](SplitArrayLargestSum.md) | [LC 410](https://leetcode.com/problems/split-array-largest-sum/) | Minimise the max sum | O(n log sum) |

## 2D Arrays
| Question (notes) | Practice | Idea | Time |
|---|---|---|---|
| [Row with Maximum 1's](RowWithMaxOnes.md) | [GfG](https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1) | First 1 per row | O(m log n) |
| [Search in 2D Matrix](Search2DMatrix.md) | [LC 74](https://leetcode.com/problems/search-a-2d-matrix/) | Flatten the index | O(log(mn)) |
| [Search in 2D Matrix II](Search2DMatrixII.md) | [LC 240](https://leetcode.com/problems/search-a-2d-matrix-ii/) | Staircase from top-right | O(m+n) |
| [Find Peak Element II](FindPeakElementII.md) | [LC 1901](https://leetcode.com/problems/find-a-peak-element-ii/) | Binary search on columns | O(m log n) |
| [Matrix Median](MatrixMedian.md) | [GfG](https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1) | Binary search on value | O(m log n · log range) |

## Quick pattern map
- **"Min of max" / "max of min"** → binary search on the answer (Painter's, Book Allocation, Split Array, Ship, Aggressive Cows, Koko).
- **Rotated array** → one half is sorted (search) or compare with `high` (minimum).
- **First/last position** → lower and upper bound.

## Run any program
```
javac -d out *.java
java -cp out LowerBound
```
