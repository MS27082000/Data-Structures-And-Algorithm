# Recursive Insertion Sort

**Idea:** Same as insertion sort, but the outer loop becomes recursion on the index `i`.

**Steps:** `insertionSort(a, i)`: base case `i >= n`. Insert `a[i]` into the sorted prefix `[0..i-1]` by shifting larger elements right, then call `insertionSort(a, i+1)`.

**Intuition:** At each call the prefix `[0..i-1]` is sorted. Inserting `a[i]` extends it by one.

**Complexity:** Time O(n²) worst, O(n) best (sorted). Space O(n) recursion stack.
**Stable?** Yes.

**Edge cases:** Empty array, single element, sorted, reverse sorted, duplicates.

**Interview traps**
- Start the call at `i = 1` (a single element is already sorted).
- Base case `i >= a.length` handles the empty array safely.
- Recursion depth is n, which can overflow the stack for very large inputs. The iterative version is safer.

**How to explain:** "Insert the element at index i into the sorted part before it, then recurse for i+1 until the end."
