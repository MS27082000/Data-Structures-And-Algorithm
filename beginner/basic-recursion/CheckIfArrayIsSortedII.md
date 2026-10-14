# Check if the Array is Sorted (Recursive)

**Problem:** Is the array sorted, using recursion?

**Intuition:** arr[i] <= arr[i+1] must hold, and the rest must also be sorted.

**Approach / complexity:** O(n) time, O(n) stack.

**Edge cases:** Empty or one element -> true.

**Interview traps**
- Base case: i >= n - 1.
- Return false immediately at the first descent.

**How to explain:** "Each call checks one adjacent pair and trusts recursion for the rest."
