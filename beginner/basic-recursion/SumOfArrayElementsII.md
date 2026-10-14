# Sum of Array Elements (Recursive)

**Problem:** Add the array elements using recursion.

**Intuition:** sum(i) = arr[i] + sum(i + 1); an index past the end contributes 0.

**Approach / complexity:** O(n) time, O(n) stack.

**Edge cases:** Empty array.

**Interview traps**
- Pass the index instead of copying subarrays (copying makes it O(n^2)).

**How to explain:** "I add the current element to the sum of the rest, stopping at the end of the array."
