# Time Complexity (Theory with Examples)

**Problem:** Measure how the running time or the number of operations grows with the input size n.

**Intuition:** Count the basic operations of the loops. Constants and lower-order terms are dropped: 3n^2 + 5n is O(n^2).

**Approach / complexity:** Common orders from fast to slow: O(1), O(log n) (halving), O(sqrt n), O(n), O(n log n) (sorting, a loop with a halving loop inside), O(n^2) (two nested loops, also n(n-1)/2), O(2^n) (branching recursion), O(n!). Space complexity counts extra memory, including the recursion stack. For about 10^8 simple operations per second: n up to 10^8 needs O(n), 10^5 allows O(n log n), 10^4 allows O(n^2), 20-25 allows O(2^n).

**Edge cases:** Best, average and worst cases differ (quicksort, hash tables). Amortised cost (ArrayList add).

**Interview traps**
- A triangular nested loop is still O(n^2).
- A loop that halves is O(log n), not O(n).
- Recursion space is the depth of the stack.
- Say which case (worst/average) you are quoting.

**How to explain:** "I count how many times the innermost statement runs as a function of n and keep the dominant term."
