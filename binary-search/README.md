# Binary Search

Source: Striver's A2Z DSA Sheet, Binary Search section (32 items). Active recall: open the link, solve from scratch, then check the notes.

## When to use

Binary search works when you can throw away **half** of the options after one check. That happens in three situations.

### 1. Sorted data
`[1, 3, 5, 7, 9]`. Look at the middle, and the target is either left or right of it.

### 2. Monotonic data
**Monotonic** means the values only go in **one direction**: they never go up and then down. (Non-decreasing or non-increasing.)

- `[1, 2, 2, 5, 9]` is monotonic (never goes down).
- `[1, 5, 3, 8]` is **not** monotonic.

It doesn't have to be an array. Hours Koko needs to eat all bananas, as her eating speed grows:

| Speed | 1 | 2 | 3 | 4 | 5 | 6 |
|---|---|---|---|---|---|---|
| Hours needed | 27 | 15 | 10 | 8 | 8 | 6 |

The hours never go up when the speed goes up, so this is monotonic. That is enough for binary search.

### 3. A yes/no condition that flips only once
Write a check `cond(x)` that answers yes or no. It must look like `no no no no yes yes yes`, with **one** switch point and no switching back.

Example: array `[2, 4, 7, 9, 12]`, `cond(i)` = "is `a[i] >= 7`?"

```
index   0     1     2     3     4
value   2     4     7     9     12
cond    no    no    yes   yes   yes
```

Binary search finds the **first yes** (index 2) without checking every index.

Another one: "can Koko finish in 8 hours at speed `x`?" gives `no no no yes yes yes` for `x = 1, 2, 3, 4, 5, 6`. The first yes (`x = 4`) is the answer.

### "Minimise the maximum" and "maximise the minimum"
These words mean: **binary search on the answer** (see below).

**Minimise the maximum.** Example: split `[7, 2, 5, 10, 8]` into `k = 2` parts so that the **largest part sum is as small as possible**.
- Guess a value `X` for the largest allowed part sum. Question: "can we split into at most 2 parts, each with sum `<= X`?"
- Small `X` (like 10): no. Big `X` (like 40): yes. So it looks like `no no no yes yes yes`.
- We want the **smallest** `X` that says yes. That is 18.

**Maximise the minimum.** Example: place `k` cows in stalls so that the **smallest distance** between any two cows is as large as possible.
- Guess a distance `d`. Question: "can we place all cows with every gap `>= d`?"
- Small `d`: yes. Big `d`: no. So it looks like `yes yes yes no no no`.
- We want the **largest** `d` that says yes.

## Two templates to memorise

### Template 1: first index where the condition is true
Use it for: lower bound, first occurrence, boundaries, and binary search on the answer.

```java
int low = 0, high = n;                       // high = n means "there may be no true at all"
while (low < high) {
    int mid = low + (high - low) / 2;
    if (cond(mid)) high = mid;               // mid is true: it could be the first true, so keep it
    else low = mid + 1;                      // mid is false: the answer is to its right
}
return low;                                  // first true (n if none)
```

Trace on `[2, 4, 7, 9, 12]` with `cond = a[i] >= 7`:

```
low=0 high=5  mid=2  a[2]=7 >= 7 yes  → high=2
low=0 high=2  mid=1  a[1]=4 >= 7 no   → low=2
low=2 high=2  stop → answer index 2
```

### Template 2: classic exact search
Use it for: "is this exact value in the sorted array? where?"

```java
int low = 0, high = n - 1;
while (low <= high) {
    int mid = low + (high - low) / 2;
    if (a[mid] == target) return mid;        // found it
    if (a[mid] < target) low = mid + 1;      // target is on the right
    else high = mid - 1;                     // target is on the left
}
return -1;                                   // not found
```

Trace on `[-1, 0, 3, 5, 9, 12]`, target `9`:

```
low=0 high=5  mid=2  a[2]=3 < 9   → low=3
low=3 high=5  mid=4  a[4]=9 == 9  → return 4
```

**Which one?** Exact value → Template 2. First or last position, a boundary, or an answer → Template 1.

## `low <= high` or `low < high`?

It depends on what the range means, and on whether you ever write `high = mid`.

| | Template 2 (exact search) | Template 1 (first true) |
|---|---|---|
| Start | `low = 0`, `high = n - 1` | `low = 0`, `high = n` |
| Range means | `[low .. high]`, both ends are real candidates | `[low .. high)`, `high` is a "none" slot |
| Moves | `low = mid + 1`, `high = mid - 1` (throw `mid` away) | `low = mid + 1`, `high = mid` (keep `mid`) |
| Loop | `while (low <= high)` | `while (low < high)` |
| Ends when | `low > high` (range is empty) | `low == high` (one answer left) |

- **Template 2, `<=`:** when `low == high` there is still one unchecked element, so it must be checked. Example `[5]`, target `5`: with `<` the loop would skip it.
- **Template 1, `<`:** we keep `mid` on a "yes" (`high = mid`), because it might be the answer. When `low == high` the range is exactly the answer. With `<=` the loop would run forever.

**Quick check:**
- You write `high = mid - 1` and `low = mid + 1` (both skip `mid`) → `low <= high`.
- You write `high = mid` (keeps `mid`) → `low < high`.

## Which template for which question?

Ask: **do I return the moment I find it, or do I narrow down to a boundary?**

| What does the question ask? | Template | Loop |
|---|---|---|
| "Is this exact value there? Return its index." You can stop as soon as `a[mid] == target`. | Template 2 | `low <= high` |
| "First / last / smallest / largest / minimum / maximum / boundary / answer in a range." You can't stop early. | Template 1 | `low < high` |

**Template 2 (return when found):**
- Binary Search (LC 704)
- Search in Rotated Sorted Array I and II (exact target)
- Search in 2D Matrix (flatten the index, exact target)

**Template 1 (narrow to the answer):**
- Lower Bound, Upper Bound, Search Insert Position, Floor and Ceil
- First and Last Occurrence, Count Occurrences (built from lower and upper bound)
- Find Minimum in Rotated Sorted Array, Rotation Count
- Single Element in Sorted Array, Find Peak Element
- Every "binary search on the answer" question: Square Root, Nth Root, Smallest Divisor, Koko, Bouquets, Ship Packages, Painter's Partition, Aggressive Cows, Book Allocation, Split Array Largest Sum, Kth Missing Positive

**Clue in the question text:**
- "Find the **index of**..." (an exact value) → Template 2.
- "Find the **smallest / minimum / first / maximum** ... such that ..." → Template 1.

**If you want just one template:** Template 1 can do exact search too. Find the lower bound `idx`, then check `idx < n && a[idx] == target`. You lose the early return, but you only need to remember one loop.

Some problems can be written either way. Treat this as a safe default, not the only correct choice.

## Binary search on the answer

Sometimes there is **no sorted array**. Instead, the possible **answers** are a range of numbers, and you binary search over that range.

Steps:
1. Find the smallest and largest possible answer. That's your `low` and `high`.
2. Write `isFeasible(x)`: a yes/no check for "does answer `x` work?"
3. Check that it flips once (`no no no yes yes yes`). If so, use Template 1 to find the first yes (for "minimise") or the last yes (for "maximise").

**Example: Koko Eating Bananas** (piles `[3, 6, 7, 11]`, finish within `h = 8` hours, find the smallest speed).
- Range of speeds: `1` to `11` (the biggest pile).
- `isFeasible(x)` = "sum of `ceil(pile / x)` over all piles `<= 8`?"

| Speed | 1 | 2 | 3 | 4 | 5 | 6 |
|---|---|---|---|---|---|---|
| Hours | 27 | 15 | 10 | 8 | 8 | 6 |
| Feasible? | no | no | no | **yes** | yes | yes |

The first yes is speed `4`. Binary search finds it in about `log(11)` checks, instead of trying all speeds.

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
