# Quick Sort

**Idea:** Pick a pivot, partition so smaller elements go left and larger go right, then sort both sides recursively. The pivot lands in its final position.

**Steps:**
1. Choose a pivot (here the middle element, swapped to the end).
2. Scan with `j`; whenever `a[j] < pivot`, swap it to position `i` and `i++`.
3. Swap the pivot into index `i`; recurse on `[low..i-1]` and `[i+1..high]`.

**Intuition:** After partitioning, the pivot is exactly where it would be in the sorted array, so the problem splits into two independent smaller problems. No merge is needed.

**Complexity:** Average O(n log n), **worst O(n²)** (bad pivots, e.g. always the smallest). Space O(log n) stack on average (O(n) worst).
**Stable?** No.

**Edge cases:** Empty, single element, all equal elements, already sorted or reverse sorted (the worst case with a first/last pivot).

**Interview traps**
- First/last pivot on sorted input → O(n²). Fix with a middle or random pivot, or median-of-three.
- Many duplicates degrade a simple partition. A 3-way partition fixes that.
- Quick sort is usually faster than merge sort in practice (cache friendly, in-place) despite the worse worst case.
- Recurse into the smaller side first to keep the stack O(log n).

**How to explain:** "Partition around a pivot so it lands in its final place, then recurse on both sides. Average n log n, worst n², avoided with a random or middle pivot."
