# Matrix Chain Multiplication

**Problem:** `dims[]` where matrix i is `dims[i-1] x dims[i]`. Minimum scalar multiplications to multiply the whole chain (order of brackets matters, not matrix order).

**Intuition (interval DP):** `f(i,j) = min over k in [i, j-1] of f(i,k) + f(k+1,j) + dims[i-1]*dims[k]*dims[j]`. `f(i,i) = 0`. Fill by increasing chain length.

**Brute force:** Try every bracketing (Catalan number).
**Optimised:** O(n^3) time, O(n^2) space.

**Edge cases:** One matrix -> 0. Two matrices -> one product.

**Interview traps**
- Indexing: matrix i uses `dims[i-1]` and `dims[i]`.
- Fill the table by length, not row by row naively.
- This "try every split point" shape powers the whole family below.

**How to explain:** "I split the chain at every point, solve both halves, and add the cost of multiplying the two results."
