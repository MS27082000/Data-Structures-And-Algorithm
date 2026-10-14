# Recursive Bubble Sort

**Idea:** Same as bubble sort, but the outer loop becomes recursion.

**Steps:** `bubbleSort(a, n)`: base case `n <= 1`. One pass over `[0..n-1]` swaps adjacent out-of-order pairs (max reaches index `n-1`). Then call `bubbleSort(a, n-1)`.

**Intuition:** After one pass the last element is final, so the remaining problem is the same one on `n-1` elements.

**Complexity:** Time O(n²) (O(n) best with the swapped check). Space O(n) recursion stack.
**Stable?** Yes.

**Edge cases:** n = 0 or 1, already sorted (returns after the first pass), duplicates.

**Interview traps**
- Base case must be `n <= 1`, or you recurse forever or go out of bounds.
- Recursion uses O(n) stack. Iterative is better in production. Mention this.
- Add the `swapped` flag to stop early on sorted input.

**How to explain:** "One bubble pass fixes the largest at the end, then I recurse on the first n-1 elements. Same as iterative bubble sort, but the loop is recursion."
