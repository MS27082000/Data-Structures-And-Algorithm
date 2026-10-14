# Largest Divisible Subset (LC 368)

**Problem:** Largest subset where every pair divides one another.

**Intuition:** Sort. In sorted order, if each element divides the next, then divisibility is **transitive**, so all pairs divide. That makes it an LIS with the condition `a[i] % a[j] == 0`. Keep parents to rebuild.

**Brute force:** All subsets, O(2^n * n^2).
**Optimised:** O(n^2) time, O(n) space.

**Edge cases:** Single element, primes only (answer size 1), includes 1 (divides all).

**Interview traps**
- Sorting is essential - say why.
- Only checking the new element against the chain's last element is enough.

**How to explain:** "After sorting, the problem becomes LIS where 'increasing' means 'divisible by the previous'."
